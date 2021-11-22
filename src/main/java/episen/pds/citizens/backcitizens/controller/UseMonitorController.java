package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.RoomsWithConsumption;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UseMonitorController {
    private UseMonitorService useMonitorService;
    private static final Logger logger = Logger.getLogger(TestController.class.getName());

    @GetMapping("/getConsumptionByBuilding")
    public Iterable<Consumption> getConsumptionByBuilding(int id_building) {
        return useMonitorService.getConsumptionByBuilding(id_building);
    }

    @GetMapping("/getRoomsWithConsumption")
    public Iterable<RoomsWithConsumption> getRoomsWithConsumption() {
        return useMonitorService.getRoomsWithConsumption();
    }

    @GetMapping("/getEquipmentByRoom")
    public Iterable<Equipment> getEquipmentByRoom(int id_room) {
        return  useMonitorService.getEquipmentByRoom(id_room);
    }
}
