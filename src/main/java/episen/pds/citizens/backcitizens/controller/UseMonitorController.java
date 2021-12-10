package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Condition;
import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.RoomsWithConsumption;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UseMonitorController {
    @Autowired
    private UseMonitorService useMonitorService;
    private static final Logger logger = Logger.getLogger(TestController.class.getName());

    @GetMapping("/getConsumptionByBuilding/{id}")
    public Iterable<Consumption> getConsumptionByBuilding(@PathVariable("id") int id_building) {
        for (Consumption row:useMonitorService.getConsumptionByBuilding(id_building)) {
            logger.info(row.toString());
        }
        return useMonitorService.getConsumptionByBuilding(id_building);
    }
/*
    @GetMapping("/getRoomsWithConsumption")
    public Iterable<RoomsWithConsumption> getRoomsWithConsumption() {
        for (RoomsWithConsumption row:useMonitorService.getRoomsWithConsumption()) {
            logger.info(row.toString());
        }
        return useMonitorService.getRoomsWithConsumption();
    }
*/
    @GetMapping("/getEquipmentsByRoom/{id}")
    public Iterable<Equipment> getEquipmentByRoom(@PathVariable("id") int id_room) {
        for (Equipment row: useMonitorService.getEquipmentByRoom(id_room)) {
            logger.info(row.toString());
        }
        return  useMonitorService.getEquipmentByRoom(id_room);
    }

    @GetMapping("/getRoomConditions/{id}")
    public Iterable<Condition> getRoomConditions(@PathVariable("id") int id_room) {
        for (Condition row:useMonitorService.getRoomConditions(id_room)) {
            logger.info(row.toString());
        }
        return useMonitorService.getRoomConditions(id_room);
    }

    @GetMapping("/getAllEquipments")
    public Iterable<Equipment> getAllEquipments() {
        for (Equipment row:useMonitorService.findEquipmentOrderByRoom()) {
            logger.info(row.toString());
        }
        return useMonitorService.findEquipmentOrderByRoom();
    }
}
