package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import episen.pds.citizens.backcitizens.model.equipments.FloorHouse;
import episen.pds.citizens.backcitizens.model.equipments.House;
import episen.pds.citizens.backcitizens.model.equipments.RoomHouse;
import episen.pds.citizens.backcitizens.service.EnergyService;
import episen.pds.citizens.backcitizens.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {

    @Autowired
    EnergyService energyService;
    private static final Logger logger = Logger.getLogger(EquipmentController.class.getName());

    @Autowired
    private EquipmentService equipmentService;


    @GetMapping("/equipmentBYRoom/{idr}")
    public Iterable<Equipment> getEquipmentBYRoom(@PathVariable("idr") String idr) {
        return equipmentService.getEquipmentBYRoom(Integer.parseInt(idr));
    }

    @PutMapping("/choosestatut")
    public void UpdateStatutMode(@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment) {
        equipmentService.UpdateStatutMode(chooseStatut, type_mode, id_equipment);
    }

    @PutMapping("/valueEquipment")
    public void UpdateValueEquipment(@RequestParam("valueEquipment") Integer valueEquipment, @RequestParam("id_equipment") Integer id_equipment) {
        equipmentService.UpdateValueEquipment(valueEquipment, id_equipment);
    }

    @GetMapping("/nameRoom")
    public String getNameRoomByIdroom(@RequestParam("id_room") Integer id_room) {
        return equipmentService.getNameRoomByIdroom(id_room);
    }

    @GetMapping("/nameEquipment")
    public String NameEquipment(@RequestParam("id_equipment") Integer id_equipment) {
        return equipmentService.NameEquipment(id_equipment);
    }

    @GetMapping("/getIdRoomByEquipment")
    public Integer getIdRoomByEquipment(@RequestParam("id_equipment") Integer id_equipment) {
        return equipmentService.getIdRoomByEquipment(id_equipment);
    }

    @GetMapping("/house")
    public List<House> getHouses(@RequestParam("email") String email) {
        System.out.println(email);
        return equipmentService.getHouseByEmail(email);
    }

    @GetMapping("/floor")
    public List<FloorHouse> getFloors(@RequestParam("house") String house) {
        System.out.println(house);
        return equipmentService.getFloors(house);
    }

    @GetMapping("/room")
    public List<RoomHouse> getRooms(@RequestParam("floor") String floor) {
        System.out.println(floor);
        return equipmentService.getRooms(floor);
    }

    @GetMapping("/EquipmentOrderByConsumption/idb={id_b}")
    public Iterable<EquipmentWithConsumption> getEquipmentOrderByConsumptionByBuilding(@PathVariable String id_b) {
        logger.info("getEquipmentOrderByConsumptionByBuilding");
        return energyService.getEquipmentByConsumption(id_b);
    }

    @GetMapping("/EquipmentOrderByConsumption/idr={id_r}")
    public Iterable<EquipmentWithConsumption> getEquipmentOrderByConsumptionByRoom(@PathVariable String id_r) {
        logger.info("getEquipmentOrderByConsumptionByRoom");
        return energyService.getEquipmentOrderByConsumptionByRoom(id_r);
    }

    @GetMapping("/CentralByProduction/{id_b}")
    public Iterable<CentralWithProduction> getCentralByProduction(@PathVariable String id_b) {
        logger.info("getCentralByProduction");
        return energyService.getCentralByProduction(id_b);
    }
}
