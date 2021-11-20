package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.controller.EquipmentController;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.repository.EquipmentWithConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class EquipmentService {

    @Autowired
    EquipmentWithConsumptionRepo equipmentWithConsumptionRepo;
    private static final Logger logger = Logger.getLogger(EquipmentService.class.getName());


    public Iterable<EquipmentWithConsumption> getEquipmentByConsumption(){
        logger.config("EquipmentService getEquipmentByConsumption");
        Iterable<EquipmentWithConsumption> equipmentWithConsumptionIterable = equipmentWithConsumptionRepo.findEquipmentByConsumption();
        logger.config(equipmentWithConsumptionIterable.toString());
        return equipmentWithConsumptionIterable;
    }
}
