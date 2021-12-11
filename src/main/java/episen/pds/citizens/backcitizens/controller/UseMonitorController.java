package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.*;
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

    @GetMapping("/getAllRooms")
    public Iterable<Room> getAllRooms() {
        for (Room row:useMonitorService.getAllRooms()) {
            logger.info(row.toString());
        }
        return useMonitorService.getAllRooms();
    }

    @PostMapping("/setEquipment/{id}/{value}")
    public void setEquipmentValue(@PathVariable("id") int id_equipment, @PathVariable("value") double value) {
        logger.info("SET: id_equipment=" + id_equipment + ", value=" + value);
        useMonitorService.setEquipmentValue(id_equipment,value);
    }
}
