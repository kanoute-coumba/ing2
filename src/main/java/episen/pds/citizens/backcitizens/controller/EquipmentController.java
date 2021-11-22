package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;
    private static final Logger logger = Logger.getLogger(EquipmentController.class.getName());

    @GetMapping("/EquipmentByConsumption/{id_b}")
    public Iterable<EquipmentWithConsumption> getEquipmentByConsumption(@PathVariable String id_b){
        logger.info("getEquipmentByConsumption");
        return equipmentService.getEquipmentByConsumption(id_b);
    }
}
