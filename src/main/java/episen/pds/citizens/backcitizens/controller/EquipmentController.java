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
    public Iterable<String> getListEquipment(@RequestParam("id_room") Integer id_room, @RequestParam("id_floor") Integer id_floor) {
        logger.config("returning values");
        return equipmentService.getEquipment(id_room, id_floor);
    }

    @GetMapping("/Lampe")
    public String getEquipmentLampe(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
        return equipmentService.recoverLampe(id_room, id_equipment);
    }

    @GetMapping("/Climatisation")
    public String getEquipmentClimatisation(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
        return equipmentService.recoverClimatisation(id_room, id_equipment);

    }


}
