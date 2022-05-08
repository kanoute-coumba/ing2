package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

@Service
public class ConsumptionService {

    private static final Logger logger = Logger.getLogger(ConsumptionService.class.getName());

    @Autowired
    public ConsumptionRepo consumptionRepo;

    public ConsumptionService() {
    }

    public Iterable<Consumption> findHistoryConsumptionByIdEquipment(String id_e){
        logger.info("EnergyService findHistoryConsumptionByIdEquipment "+id_e);
        return consumptionRepo.findHistoryConsumptionByIdEquipment(Integer.parseInt(id_e));
    }
    public Iterable<Consumption> findHistoryConsumptionByIdEquipmentBetweenTwoDate(String id_e,
                                                                                   long dBegin,
                                                                                   long dEnd){
        logger.info("ConsumptionService findHistory" +
                "ConsumptionByIdEquipmentBetweenTwoDate "+id_e+" "+dBegin+" "+dEnd);

        return consumptionRepo.findHistoryConsumptionByIdEquipmentBetweenTwoDate(
                Integer.parseInt(id_e), dBegin,dEnd);
    }
    public Iterable<Consumption> findHistoryConsumptionByIdRoomBetweenTwoDate(String id_r,
                                                                              long dBegin,
                                                                              long dEnd){
        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdRoomBetweenTwoDate(Integer.parseInt(id_r), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByRoomBefore(Integer.parseInt(id_r),dBegin);
        return getConsumptionsFirst(consumptionArrayList, c);
    }

    public Iterable<Consumption> getConsumptionsFirst(ArrayList<Consumption> consumptionArrayList, ArrayList<Consumption> c) {
        HashMap<Integer,Consumption> hashMap = new HashMap<>();
        ArrayList<Consumption> sortie = new ArrayList<>();
        double somme = 0.0;
        if(!c.isEmpty()) {
            for (Consumption consumption : c) {
                hashMap.put(consumption.getId_equipment(), consumption);
                somme += consumption.getValue();
            }
            sortie.add(new Consumption(c.get( c.size()- 1).getId_consumption(),
                    somme, c.get( c.size()- 1).getDate_time(), c.get( c.size()- 1).getId_equipment()));
        }
        return getConsumptionsSecond(consumptionArrayList, hashMap, sortie, somme);
    }

    public Iterable<Consumption> getConsumptionsSecond(ArrayList<Consumption> consumptionArrayList, HashMap<Integer, Consumption> hashMap, ArrayList<Consumption> sortie, double somme) {
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
        return cleanList(sortie);
    }

    public Iterable<Consumption> findHistoryConsumptionByIdFloorBetweenTwoDate(String id_f,
                                                                              long dBegin,
                                                                              long dEnd){
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
        return getConsumptionsSecond(consumptionArrayList, hashMap, sortie, somme);
    }

    public Iterable<Consumption> findHistoryConsumptionByIdBuildingBetweenTwoDate(String id_b,
                                                                               long dBegin,
                                                                               long dEnd){
        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdBuildingBetweenTwoDate(Integer.parseInt(id_b), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByBuildingBefore(Integer.parseInt(id_b),dBegin);
        return getConsumptionsFirst(consumptionArrayList, c);
    }
    public ArrayList<Consumption> cleanList(ArrayList<Consumption> arrayList){
        if (arrayList.size() <3){
            logger.info(arrayList+"");
            return arrayList;
        }
        else {
            Consumption c1 = arrayList.get(0);
            Consumption c3 ;
            ArrayList<Consumption> consumptionArrayList = new ArrayList<>();
            consumptionArrayList.add(c1);
            for(int i=1; i<arrayList.size()-1;i++){
                c3 = arrayList.get(i+1);
                if (!(c3.getValue()== c1.getValue() && c1.getValue()==arrayList.get(i).getValue())){
                    consumptionArrayList.add(arrayList.get(i));
                    c1 = arrayList.get(i);
                }
            }
            Consumption c = arrayList.get(arrayList.size()-1);
            if (!consumptionArrayList.contains(c)){
            consumptionArrayList.add(c);}
            logger.info(consumptionArrayList+"");
            return consumptionArrayList;
        }
    }

    public Consumption consumptionByIdBuildingNow(int idb){
        Timestamp timestamp = Timestamp.from(Instant.now());
        long dBegin = timestamp.getTime()/1000;
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByBuildingBefore(idb,dBegin);
        double somme = 0.0;
        for (Consumption consumption : c) {
            somme += consumption.getValue();
        }
        somme = (int) somme;
        return new Consumption(0, somme, dBegin, 0);
    }

    public Consumption consumptionByIdRoomNow(int idr){
        Timestamp timestamp = Timestamp.from(Instant.now());
        long dBegin = timestamp.getTime()/1000;
        ArrayList<Consumption> c = consumptionRepo.findConsumptionByRoomBefore(idr,dBegin);
        double somme = 0.0;
        for (Consumption consumption : c) {
            somme += consumption.getValue();
        }
        somme = (int) somme;
        return new Consumption(0, somme, dBegin, 0);
    }
}
