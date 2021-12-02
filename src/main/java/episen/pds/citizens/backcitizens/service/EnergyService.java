package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.repository.CentralWithProductionRepo;
import episen.pds.citizens.backcitizens.repository.EquipmentWithConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class EnergyService {

    @Autowired
    EquipmentWithConsumptionRepo equipmentWithConsumptionRepo;
    @Autowired
    CentralWithProductionRepo centralWithProductionRepo;
    private static final Logger logger = Logger.getLogger(EnergyService.class.getName());


    public Iterable<EquipmentWithConsumption> getEquipmentByConsumption(String id_b){
        logger.info("EnergyService getEquipmentByConsumption");
        Iterable<EquipmentWithConsumption> a = equipmentWithConsumptionRepo.findEquipmentByConsumption(Integer.parseInt(id_b));
        logger.info(a.toString());
        return a;
    }
    public Iterable<CentralWithProduction> getCentralByProduction(String id_b){
        logger.info("EnergyService getCentralByProduction");
        Iterable<CentralWithProduction> a = centralWithProductionRepo.getCentralWithProduction(Integer.parseInt(id_b));
        logger.info(a.toString());
        return a;
    }
}
