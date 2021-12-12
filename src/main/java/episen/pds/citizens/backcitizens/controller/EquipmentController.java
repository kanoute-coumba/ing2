package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Equipment;

import episen.pds.citizens.backcitizens.service.EquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.service.EnergyService;
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
    EnergyService energyService;
    private static final Logger logger = Logger.getLogger(EquipmentController.class.getName());

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/ListEquipment")
    public Iterable<String> getListEquipment(@RequestParam("id_room") Integer id_room, @RequestParam("id_floor") Integer id_floor) {
        logger.config("returning values");
        return equipmentService.getEquipment(id_room, id_floor);
    }

    @GetMapping("/equipmentBYRoom/{idr}")
    public Iterable<Equipment> getEquipmentBYRoom(@PathVariable("idr") String idr) {
        return equipmentService.getEquipmentBYRoom(Integer.parseInt(idr));
    }

    @PutMapping("/choosestatut")
    public void UpdateStatutMode (@RequestParam("chooseStatut") String chooseStatut, @RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment) {
         equipmentService.UpdateStatutMode(chooseStatut, type_mode, id_equipment);
    }

    @GetMapping("/nameRoom")
    public String getNameRoomByIdroom (@RequestParam("id_room") Integer id_room) {
        return equipmentService.getNameRoomByIdroom(id_room);
    }








//    @GetMapping("/Lampe")
//    public String getEquipmentLampe(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        return equipmentService.recoverLampe(id_room, id_equipment);
//    }
//
//    @GetMapping("/Climatisation")
//    public String getEquipmentClimatisation(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        return equipmentService.recoverClimatisation(id_room, id_equipment);
//
//    }
//
//    @GetMapping("/Radiateur")
//    public String getEquipmentRadiateur(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        return equipmentService.recoverRadiateur(id_room, id_equipment);
//    }
//
//    @GetMapping("/Fenetre")
//    public String getEquipmentFenetre(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        return equipmentService.recoverFenetre(id_room, id_equipment);
//    }
//
//    @GetMapping("/Store")
//    public String getEquipmentStore(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        return equipmentService.recoverStore(id_room, id_equipment);
//    }
//
//    @GetMapping("/Screen")
//    public String getEquipmentScreen(@RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        return equipmentService.recoverScreen(id_room, id_equipment);
//    }

//    @PutMapping("/updateLampe")
//    public void updateStatutLampe(@RequestBody Equipment equipment) {
//        equipmentService.updateStatutLampe(equipment);
//        logger.info("update done");
//
//    }
//
//    @PutMapping("/updateLampe")
//    public void updateStatutLampe(@RequestBody Equipment equipment,  @RequestParam("id_room") Integer id_room, @RequestParam("id_equipment") Integer id_equipment) {
//        equipmentService.updateStatutLampe(equipment.getStatut(), equipment.getType_mode(), id_room, id_equipment);
//    }

    @GetMapping("/EquipmentOrderByConsumption/idb={id_b}")
    public Iterable<EquipmentWithConsumption> getEquipmentOrderByConsumptionByBuilding(@PathVariable String id_b){
        logger.info("getEquipmentOrderByConsumptionByBuilding");
        return energyService.getEquipmentByConsumption(id_b);
    }
    @GetMapping("/EquipmentOrderByConsumption/idr={id_r}")
    public Iterable<EquipmentWithConsumption> getEquipmentOrderByConsumptionByRoom(@PathVariable String id_r){
        logger.info("getEquipmentOrderByConsumptionByRoom");
        return energyService.getEquipmentOrderByConsumptionByRoom(id_r);
    }
    @GetMapping("/CentralByProduction/{id_b}")
    public Iterable<CentralWithProduction> getCentralByProduction(@PathVariable String id_b){
        logger.info("getCentralByProduction");
        return energyService.getCentralByProduction(id_b);
    }
}
