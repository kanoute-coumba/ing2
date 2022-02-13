package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
                                                                                   LocalDateTime dBegin,
                                                                                   LocalDateTime dEnd){
        logger.info("EnergyService findHistoryConsumptionByIdEquipmentBetweenTwoDate "+id_e);
        return consumptionRepo.findHistoryConsumptionByIdEquipmentBetweenTwoDate(Integer.parseInt(id_e), dBegin,dEnd);
    }
}
