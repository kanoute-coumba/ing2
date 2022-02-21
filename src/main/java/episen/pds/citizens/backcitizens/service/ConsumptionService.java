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
        logger.info("EnergyService findHistory" +
                "ConsumptionByIdEquipmentBetweenTwoDate "+id_e+" "+dBegin+" "+dEnd);

        return consumptionRepo.findHistoryConsumptionByIdEquipmentBetweenTwoDate(
                Integer.parseInt(id_e), dBegin,dEnd);
    }
    public Iterable<Consumption> findHistoryConsumptionByIdRoomBetweenTwoDate(String id_r,
                                                                              long dBegin,
                                                                              long dEnd){
        ArrayList<Consumption> consumptionArrayList = consumptionRepo.findHistoryConsumptionByIdRoomBetweenTwoDate(Integer.parseInt(id_r), dBegin,dEnd);
        ArrayList<Consumption> c = consumptionRepo.findEquipmentWithConsumptionByRoomBefore(Integer.parseInt(id_r),dBegin);
        HashMap<Integer,Consumption> hashMap = new HashMap();
        ArrayList<Consumption> sortie = new ArrayList<>();
        double somme = 0.0;
        for (Consumption consumption : c) {
            somme += consumption.getValue();
        }
        sortie.add(new Consumption(c.get(c.size()-1).getId_consumption(),
                somme,c.get(c.size()-1).getDate_time(),c.get(c.size()-1).getId_equipment()));
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
        return sortie;
    }

}
