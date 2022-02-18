package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.model.equipments.*;
import episen.pds.citizens.backcitizens.service.EnergyService;
import episen.pds.citizens.backcitizens.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {

    @Autowired
    EnergyService energyService;
    private static final Logger logger = Logger.getLogger(EquipmentController.class.getName());
    private static int hours = 0;

    @Autowired
    private EquipmentService equipmentService;


    @GetMapping("/equipmentBYRoom/{idr}")
    public Iterable<Map<String, String>> getEquipmentBYRoom(@PathVariable("idr") String idr) {
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
    public List <Building> getHouses(@RequestParam("email") String email) {

        System.out.println(email + " kkkkkk");
        return equipmentService.getHouseByEmail(email);
    }

    @GetMapping("/floor")
    public List<Floor> getFloors(@RequestParam("house") String house) {
        System.out.println(house);
        System.out.println(equipmentService.getFloors(house));
        return equipmentService.getFloors(house);
    }

    @GetMapping("/room")
    public List<Room> getRooms(@RequestParam("floor") String floor) {
        System.out.println(floor);
        return equipmentService.getRooms(floor);
    }

    @PutMapping("updateAuto")
    public void updateStatutAuto(@RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment) {
        equipmentService.updateStatutAuto(type_mode, id_equipment);

    }


//    @PutMapping("/lampeAuto/{id}")
//    public void getEquipmentLampeAutomatic(@PathVariable("id") String id) {
//        ThreadLight threadLight = new ThreadLight(equipmentService, id);
//        threadLight.run();
//    }

    @Scheduled(fixedRate = 2000)
    public void updateLightAutomatic() {

        if ((hours >= 0 && hours < 7) || (hours >= 8 && hours < 18)) {
            List<Integer> id_equipment_data = equipmentService.getEquipmentLampeAutomatic("ON");
            for (int i = 0; i < id_equipment_data.size(); i++) {
                equipmentService.updateStatutAutomaticLight(id_equipment_data.get(i), "OFF", 0);

            }

        } else if ((hours >= 7 && hours < 8) || (hours >= 18 && hours <= 23)) {
            List<Integer> id_equipment_data = equipmentService.getEquipmentLampeAutomatic("OFF");
            for (int i = 0; i < id_equipment_data.size(); i++) {
                if ((hours >= 18 && hours <= 23)) {
                    equipmentService.updateStatutAutomaticLight(id_equipment_data.get(i), "ON", 10);
                } else {
                    equipmentService.updateStatutAutomaticLight(id_equipment_data.get(i), "ON", 5);
                }
            }
        }

        if ((hours >= 0 && hours < 9) || (hours >= 13 && hours < 20)) {
            System.out.println("en début");
            List<Integer> listId = equipmentService.getEquipmentScreenAutomaticF("ON");
            for (int i = 0; i < listId.size(); i++) {
                equipmentService.updateStatutAutomaticScreen(listId.get(i), "OFF", 0);
                System.out.println(listId.get(i) + "liste 0h et 9h F");
            }

        } else if ((hours >= 9 && hours < 13) || (hours >= 20 && hours <= 23)) {
            System.out.println("au milieu");
            List<Integer> listIdl = equipmentService.getEquipmentScreenAutomaticF("OFF");
            for (int i = 0; i < listIdl.size(); i++) {
                equipmentService.updateStatutAutomaticScreen(listIdl.get(i), "ON", 1);
                System.out.println(listIdl.get(i) + "TTT");
            }
        }

//        else if((hours >= 0 && hours < 9) || (hours >= 13 && hours < 20)) {
//            System.out.println("en fin");
//            List<Integer> listId = equipmentService.getEquipmentScreenAutomaticF("OFF");
//            for (int i = 0; i < listId.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listId.get(i), "ON", 1);
//                System.out.println(listId.get(i) + "FFF");
//            }
//        }
//        else if((hours >= 9 && hours < 13) || (hours >= 20 && hours <= 23)) {
//            List<Integer> listIdl = equipmentService.getEquipmentScreenAutomaticT("ON");
//            for (int i = 0; i < listIdl.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdl.get(i), "OFF", 0);
//                System.out.println(listIdl.get(i) + "TTT");
//            }
//        }


        hours++;
        if (hours == 25) {
            hours = 0;
        }
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
