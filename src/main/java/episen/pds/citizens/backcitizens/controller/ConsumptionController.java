package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.service.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConsumptionController {

    private static final Logger logger = Logger.getLogger(ConsumptionController.class.getName());
    @Autowired
    ConsumptionService consumptionService;


    @GetMapping("/ConsumptionEquipment/{ide}")
    public Iterable<Consumption> findHistoryConsumptionByIdEquipment(@PathVariable("ide") String id_e){
        logger.info("findHistoryConsumptionByIdEquipment");
        return consumptionService.findHistoryConsumptionByIdEquipment(id_e);
    }
}
