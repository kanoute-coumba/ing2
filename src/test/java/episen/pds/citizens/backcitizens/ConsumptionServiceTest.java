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

import java.util.ArrayList;
import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
public class ConsumptionServiceTest extends TestCase {
    @InjectMocks
    ConsumptionService consumptionService = new ConsumptionService();

    @Mock
    ConsumptionRepo consumptionRepo;

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
