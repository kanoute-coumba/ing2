package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.*;

import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<EquipmentAndData> getEquipmentByRoom(@PathVariable("id") int id_room) {
        for (EquipmentAndData row: useMonitorService.getEquipmentAndDataByRoom(id_room)) {
            logger.info(row.toString());
        }
        return  useMonitorService.getEquipmentAndDataByRoom(id_room);
    }

    @GetMapping("/getRoomConditions/{id}")
    public Conditions getRoomConditions(@PathVariable("id") int id_room) {
        logger.info(useMonitorService.getRoomConditions(id_room).toString());
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
        for (Room row:useMonitorService.findAllBusinessRoom()) {
            logger.info(row.toString());
        }
        return useMonitorService.findAllBusinessRoom();
    }

    @PostMapping("/setEquipment/{id}/{value}")
    public void setEquipmentValue(@PathVariable("id") int id_equipment, @PathVariable("value") double value) {
        logger.info("SET: id_equipment=" + id_equipment + ", value=" + value);
        useMonitorService.setEquipmentValue(id_equipment,value);
    }

    @PostMapping("/setEquipmentAuto/{id}")
    public void setEquipmentAuto(@PathVariable("id") int id_equipment) {
        logger.info("SET_AUTO: id_equipment=" + id_equipment);
        useMonitorService.setEquipmentAuto(id_equipment);
    }

    @PostMapping("/setEquipmentManu/{id}")
    public void setEquipmentManu(@PathVariable("id") int id_equipment) {
        logger.info("SET_MANU: id_equipment=" + id_equipment);
        useMonitorService.setEquipmentManu(id_equipment);
    }

    @PostMapping("/setEquipmentOff/{id}")
    public void setEquipmentOff(@PathVariable("id") int id_equipment) {
        logger.info("SET_OFF: id_equipment=" + id_equipment);
        useMonitorService.setEquipmentOff(id_equipment);
    }

    @PostMapping("/setEquipmentOn/{id}")
    public void setEquipmentOn(@PathVariable("id") int id_equipment) {
        logger.info("SET_OFF: id_equipment=" + id_equipment);
        useMonitorService.setEquipmentOn(id_equipment);
    }

    @GetMapping("/getLastBestConditions/{id_room}")
    public Conditions getLastBestConditions(@PathVariable("id_room") int id_room) {
        logger.info("GET_COND: id_room=" + id_room);
        logger.info(useMonitorService.getLastBestConditions(id_room).toString());
        return useMonitorService.getLastBestConditions(id_room);
    }

    @GetMapping("/getLastMeasures/{id_room}")
    public Conditions getMeasuresConditions(@PathVariable("id_room") int id_room) {
        logger.info("GET_CURRENT_COND: id_room=" + id_room);
        Conditions current_condition = new Conditions();
        current_condition.setId_room(id_room);
        current_condition.setLuminosity(useMonitorService.getLastLightMeasure(id_room).getValue());
        current_condition.setTemperature(useMonitorService.getLastTempMeasure(id_room).getValue());
        logger.info("CURRENT_COND : " + current_condition.toString());
        return current_condition;
    }

    @PostMapping("/setBestConditions/{id_room}")
    public void setBestConditions(@PathVariable("id_room") int id_room, @RequestParam("cond") Conditions best_conditions) {
        best_conditions.setId_room(id_room);
        useMonitorService.setBestConditions(best_conditions);
    }
}
