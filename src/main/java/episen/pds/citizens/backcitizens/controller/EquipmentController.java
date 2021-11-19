package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Equipment;

import episen.pds.citizens.backcitizens.service.EquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;
    private static final Logger logger = Logger.getLogger(EquipmentController.class.getName());

    @GetMapping("/ListEquipment")
    public Iterable<String> getListEquipment(@RequestParam("typEquipement") String typEquipment, @RequestParam("location") String location) {
        logger.config("returning values");
        return equipmentService.getEquipment(typEquipment,location);
    }


}
