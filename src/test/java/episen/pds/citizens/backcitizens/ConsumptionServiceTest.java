package episen.pds.citizens.backcitizens;


import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import episen.pds.citizens.backcitizens.service.ConsumptionService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
public class ConsumptionServiceTest extends TestCase {
    @InjectMocks
    ConsumptionService consumptionService = new ConsumptionService();

    @Mock
    ConsumptionRepo consumptionRepo;

    @Test
    public void testConsumptionByIdBuildingNow(){ // ne marche pas
        int idb = 11534;
        Timestamp timestamp = Timestamp.from(Instant.now());
        long dBegin = timestamp.getTime()/1000;
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByFloorBefore(idb,dBegin);
        double somme = 0.0;
        for (Consumption consumption : c) {
            somme += consumption.getValue();
        }
        somme = (int) somme;
        Consumption consumption = new Consumption(0, somme, dBegin, 0);
        assertEquals(consumption,consumptionService.consumptionByIdBuildingNow(idb));
    }
    @Test
    public void testGetConsumptionsFirst() { // ne marche pas
        // l'entré
        ArrayList<Consumption> c = new ArrayList<>();
        ArrayList<Consumption> consumptionArrayList = new ArrayList<>();
        c.add( new Consumption(1,1.0,1,1));
        c.add( new Consumption(2,1.0,2,2));
        c.add( new Consumption(3,1.0,3,3));
        consumptionArrayList.add( new Consumption(4,1.0,4,1));
        consumptionArrayList.add( new Consumption(5,3.0,5,1));
        consumptionArrayList.add( new Consumption(6,6.0,5,2));
        consumptionArrayList.add( new Consumption(7,2.0,6,3));
        consumptionArrayList.add( new Consumption(8,12.0,6,2));
        consumptionArrayList.add( new Consumption(9,2.0,6,4));
        // la sortie
        ArrayList<Consumption> e = new ArrayList<>();
        e.add(new Consumption(3, 3.0,3,3));
        e.add(new Consumption(4, 3.0, 4, 1));
        e.add(new Consumption(5, 5.0, 5, 1));
        e.add(new Consumption(6, 10.0, 5, 2));
        e.add(new Consumption(7, 11.0, 6, 3));
        e.add(new Consumption(8, 17.0, 6, 2));
        e.add(new Consumption(9, 19.0, 6, 4));
        // la comparaison
        assertEquals(e,consumptionService.getConsumptionsFirst(consumptionArrayList,c));
    }
    @Test
    public void testGetConsumptionsSecond() {
        //entré
        ArrayList<Consumption> consumptionArrayList = new ArrayList<>();
        consumptionArrayList.add(new Consumption(4, 1.0, 4, 1));
        consumptionArrayList.add(new Consumption(5, 3.0, 5, 1));
        consumptionArrayList.add(new Consumption(6, 6.0, 5, 2));
        consumptionArrayList.add(new Consumption(7, 2.0, 6, 3));
        consumptionArrayList.add(new Consumption(8, 12.0, 6, 2));
        consumptionArrayList.add(new Consumption(9, 2.0, 6, 4));
        HashMap<Integer, Consumption> hashMap = new HashMap<>();
        ArrayList<Consumption> sortie = new ArrayList<>();
        double somme = 0.0;

        //sortie
        for (Consumption consumption : consumptionArrayList) {
            if (hashMap.containsKey(consumption.getId_equipment())) {
                somme = somme - hashMap.get(consumption.getId_equipment()).getValue() + consumption.getValue();
                hashMap.replace(consumption.getId_equipment(), consumption);
            } else {
                hashMap.put(consumption.getId_equipment(), consumption);
                somme = somme + consumption.getValue();
            }
            Consumption consumption1 = new Consumption(consumption.getId_consumption(),
                    somme, consumption.getDate_time(), consumption.getId_equipment());
            sortie.add(consumption1);
        }
        //comparaison
        assertEquals(consumptionService.cleanList(sortie),
                consumptionService.getConsumptionsSecond(consumptionArrayList, new HashMap<>(), new ArrayList<>(), 0.0));
    }

    @Test
    public void testFindHistoryConsumptionByIdEquipment(){
        String id_e = "1";
        assertEquals(consumptionRepo.findHistoryConsumptionByIdEquipment(Integer.parseInt(id_e)),
                consumptionService.findHistoryConsumptionByIdEquipment(id_e));
    }
    @Test
    public void testFindHistoryConsumptionByIdEquipmentBetweenTwoDate(){
        String id_e = "1";
        long dBegin = 1;
        long dEnd= 2000000000;

        assertEquals(consumptionRepo.findHistoryConsumptionByIdEquipmentBetweenTwoDate(
                Integer.parseInt(id_e), dBegin,dEnd),
                consumptionService.findHistoryConsumptionByIdEquipmentBetweenTwoDate(id_e,dBegin,dEnd)
                );
    }
    @Test
    public void testFindHistoryConsumptionByIdRoomBetweenTwoDate(){
        String id_r = "1";
        long dBegin = 1;
        long dEnd= 2000000000;

        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdRoomBetweenTwoDate(Integer.parseInt(id_r), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByRoomBefore(Integer.parseInt(id_r),dBegin);

        assertEquals(consumptionService.getConsumptionsFirst(consumptionArrayList, c),
                consumptionService.findHistoryConsumptionByIdRoomBetweenTwoDate(id_r,dBegin,dEnd));
    }
    @Test
    public void testCleanList(){
        ArrayList<Consumption> arrayList = new ArrayList<>();
        Consumption co1 = new Consumption(1,1.0,1,1);
        Consumption co2 = new Consumption(1,1.0,2,1);
        Consumption co3 = new Consumption(1,1.0,3,1);
        Consumption co4 = new Consumption(1,1.0,4,1);
        Consumption co5 = new Consumption(1,3.0,5,1);
        arrayList.add(co1);
        arrayList.add(co2);
        arrayList.add(co3);
        arrayList.add(co4);
        arrayList.add(co5);
        // La liste arrayList à 'nettoyer' est trié par date. On fait en sorte d'éliminer les valeurs
        // inutile dans cette liste, car déductible à partir des autres.
        ArrayList<Consumption> result = new ArrayList<>();
        result.add(co1);
        result.add(co4);
        result.add(co5);
        // la liste result est le résultat attendu.
        assertEquals(result,consumptionService.cleanList(arrayList));
    }
    @Test
    public void testFindHistoryConsumptionByIdBuildingBetweenTwoDate(){
        String id_b = "1";
        long dBegin = 1;
        long dEnd= 2000000000;
        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdBuildingBetweenTwoDate(Integer.parseInt(id_b), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByBuildingBefore(Integer.parseInt(id_b),dBegin);
        HashMap<Integer,Consumption> hashMap = new HashMap<>();
        ArrayList<Consumption> sortie = new ArrayList<>();
        double somme = 0.0;
        if(!c.isEmpty()) {
            for (Consumption consumption : c) {
                hashMap.put(consumption.getId_equipment(), consumption);
                somme += consumption.getValue();
            }
            sortie.add(new Consumption(c.get( c.size()- 1).getId_consumption(),
                    somme, c.get( c.size()- 1).getDate_time(), c.get(c.size()- 1).getId_equipment()));
        }
        for (Consumption consumption : consumptionArrayList) {
            if (hashMap.containsKey(consumption.getId_equipment())) {
                somme = somme - hashMap.get(consumption.getId_equipment()).getValue() + consumption.getValue();
                hashMap.replace(consumption.getId_equipment(),consumption);
            }
            else {
                hashMap.put(consumption.getId_equipment(),consumption);
                somme = somme + consumption.getValue();
            }
            Consumption consumption1 = new Consumption(consumption.getId_consumption(),
                    somme, consumption.getDate_time(), consumption.getId_equipment());
            sortie.add(consumption1);
        }
        Iterable<Consumption> result = consumptionService.cleanList(sortie);
        assertEquals(result,consumptionService.findHistoryConsumptionByIdBuildingBetweenTwoDate(id_b,dBegin,dEnd));
    }
    @Test
    public void testFindHistoryConsumptionByIdFloorBetweenTwoDate(){
        String id_f = "1";
        long dBegin = 0;
        long dEnd = 2000000000;
        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdFloorBetweenTwoDate(Integer.parseInt(id_f), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByFloorBefore(Integer.parseInt(id_f),dBegin);
        HashMap<Integer,Consumption> hashMap = new HashMap<>();
        ArrayList<Consumption> sortie = new ArrayList<>();
        double somme = 0.0;
        if(!c.isEmpty()) {
            for (Consumption consumption : c) {
                hashMap.put(consumption.getId_equipment(), consumption);
                somme += consumption.getValue();
            }

            sortie.add(new Consumption(0,
                    somme, c.get(c.size()-1).getDate_time(), 0));

        }
        for (Consumption consumption : consumptionArrayList) {
            if (hashMap.containsKey(consumption.getId_equipment())) {

                somme = somme - hashMap.get(consumption.getId_equipment()).getValue() + consumption.getValue();
                hashMap.replace(consumption.getId_equipment(),consumption);
            }
            else {

                hashMap.put(consumption.getId_equipment(),consumption);
                somme = somme + consumption.getValue();
            }
            Consumption consumption1 = new Consumption(consumption.getId_consumption(),
                    somme, consumption.getDate_time(), consumption.getId_equipment());
            sortie.add(consumption1);

        }
        assertEquals(consumptionService.cleanList(sortie),consumptionService.findHistoryConsumptionByIdFloorBetweenTwoDate(id_f,dBegin,dEnd));
    }

}
