package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

@Service
public class ConsumptionService {

    private static final Logger logger = Logger.getLogger(ConsumptionService.class.getName());

    @Autowired
    ConsumptionRepo consumptionRepo;

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
        ArrayList<Consumption> c = consumptionRepo.findEquipmentWithConsumptionByRoomBefore(Integer.parseInt(id_r),dBegin);
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
        ArrayList<Consumption> c = consumptionRepo.findEquipmentWithConsumptionByFloorBefore(Integer.parseInt(id_f),dBegin);
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
        return cleanList(sortie);
    }

    public Iterable<Consumption> findHistoryConsumptionByIdBuildingBetweenTwoDate(String id_b,
                                                                               long dBegin,
                                                                               long dEnd){
        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdBuildingBetweenTwoDate(Integer.parseInt(id_b), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findEquipmentWithConsumptionByBuildingBefore(Integer.parseInt(id_b),dBegin);
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
        return cleanList(sortie);
    }
    public ArrayList<Consumption> cleanList(ArrayList<Consumption> arrayList){
        if (arrayList.size() <3){
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
            return consumptionArrayList;
        }
    }
}
