package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.model.equipments.Room;
import episen.pds.citizens.backcitizens.service.EnergyService;
import episen.pds.citizens.backcitizens.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {

    @Autowired
    EnergyService energyService;
    private static final Logger logger = Logger.getLogger(EquipmentController.class.getName());
    private static Timestamp hours = null;
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
    public List<Building> getHouses(@RequestParam("email") String email) {
        System.out.println(email + " kkkkkk");
        System.out.println(equipmentService.getHouseByEmail(email));
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



    @PutMapping("/updateAuto")
    public void updateStatutAuto(@RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment) {
        equipmentService.updateStatutAuto(type_mode, id_equipment);

    }

    @GetMapping("/valuepresence")
    public Integer getCurrentlyValueSensor(@RequestParam("idroom") Integer idroom, @RequestParam("currentdate") String currentdate) {
        return equipmentService.getCurrentlyValueSensor(idroom, currentdate);
    }


    @GetMapping("/updateAutoEquip")
    public void updateAutomatic(@RequestParam("meeting_time") String meeting_time, @RequestParam("nameroom") String nameroom, @RequestParam("typesensor") String typesensor ) {

        String d = meeting_time.replace('T', ' ') + ":00";
        hours = Timestamp.valueOf(d);
        System.out.println(hours);


        if ((hours.after(Timestamp.valueOf("2022-01-01 00:00:00")) && hours.before(Timestamp.valueOf("2022-01-01 07:00:00")))) {

            //Integer valueSensor = equipmentService.getValueSensor(nameroom,typesensor, date1, date2);
            // recupère la liste des équipements dont le statut est ON (si valeur = 0 ) = presence = false
            List<Integer> id_equipment_data_false = equipmentService.getEquipmentAutomaticPresenceFalse("ON", "capteur de présence", 0);

            // recupère la liste des équipements dont le statut est ON (si valeur = 1) = presence = true
            List<Integer> id_equipment_data_true = equipmentService.getEquipmentAutomaticPresenceTrue("OFF", "capteur de présence", 1);

            // mise à jour des lampes ou la présence est false
            for (int i = 0; i < id_equipment_data_false.size(); i++) {
                equipmentService.updateStatutAutomaticLight(id_equipment_data_false.get(i), "OFF", 0);
            }


            //mise à jour des lampes ou la présence est vrai
            for (int i = 0; i < id_equipment_data_true.size(); i++) {
                equipmentService.updateStatutAutomaticLight(id_equipment_data_true.get(i), "ON", 5);

            }

        }
//        else if(hours.after(Timestamp.valueOf("2022-05-31 08:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 18:00:00"))) {
//
//        }





//        else if ((hours.after(Timestamp.valueOf("2022-05-31 07:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 08:00:00"))) || (hours.after(Timestamp.valueOf("2022-05-31 18:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 23:00:00")))) {
//            List<Integer> id_equipment_data = equipmentService.getEquipmentAutomatic("OFF", "capteur de presence", 0, 49);
//            for (int i = 0; i < id_equipment_data.size(); i++) {
//                if ((hours.after(Timestamp.valueOf("2022-05-31 18:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 23:00:00")))) {
//                    equipmentService.updateStatutAutomaticLight(id_equipment_data.get(i), "ON", 10);
//                } else {
//                    equipmentService.updateStatutAutomaticLight(id_equipment_data.get(i), "ON", 5);
//                }
//            }
//        }
//
//        if ((hours.after(Timestamp.valueOf("2022-05-31 00:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 09:00:00"))) || (hours.after(Timestamp.valueOf("2022-05-31 13:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 20:00:00")))) {
//            System.out.println("en début");
//            List<Integer> listId = equipmentService.getEquipmentScreenAutomaticF("ON");
//            for (int i = 0; i < listId.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listId.get(i), "OFF", 0);
//
//            }
//
//        } else if ((hours.after(Timestamp.valueOf("2022-05-31 09:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 13:00:00"))) || (hours.after(Timestamp.valueOf("2022-05-31 20:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 23:00:00")))) {
//
//            List<Integer> listIdl = equipmentService.getEquipmentScreenAutomaticF("OFF");
//            for (int i = 0; i < listIdl.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdl.get(i), "ON", 1);
//
//            }
//        }
//
//        // gestion déclenchement automatique radiateur et climatisateur
//
//        if (hours.after(Timestamp.valueOf("2022-05-31 00:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 12:00:00"))) {
//            System.out.println("début hiver matin entre 0h et 12h ");
//            List<Integer> listIdRadiator = equipmentService.getEquipmentRadiatorAutomaticWinter("OFF");
//            List<Integer> listIdAirconditioner = equipmentService.getEquipmentAirconditionerAutomaticWinter("ON");
//
//            System.out.println(listIdRadiator.size() + " size");
//            for (int i = 0; i < listIdRadiator.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdRadiator.get(i), "ON", 1);
//                System.out.println(listIdRadiator.get(i));
//            }
//
//            for (int i = 0; i < listIdAirconditioner.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdAirconditioner.get(i), "OFF", 0);
//                System.out.println(listIdRadiator.get(i));
//            }
//
//        } else if (hours.after(Timestamp.valueOf("2022-05-31 21:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 23:00:00"))) {
//            System.out.println("début hiver soirée entre 21h et 23h");
//            List<Integer> listIdRadiator = equipmentService.getEquipmentRadiatorAutomaticWinter("OFF");
//            List<Integer> listIdAirconditioner = equipmentService.getEquipmentAirconditionerAutomaticWinter("ON");
//
//
//            for (int i = 0; i < listIdRadiator.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdRadiator.get(i), "ON", 4);
//
//            }
//
//            for (int i = 0; i < listIdAirconditioner.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdAirconditioner.get(i), "OFF", 0);
//                System.out.println(listIdAirconditioner.get(i));
//            }
//        } else if (hours.after(Timestamp.valueOf("2022-05-31 12:00:00")) && hours.before(Timestamp.valueOf("2022-05-31 21:00:00"))) {
//            System.out.println("début été dans l'après midi");
//            List<Integer> listIdRadiator = equipmentService.getEquipmentRadiatorAutomaticSummer("ON");
//            List<Integer> listIdAirconditioner = equipmentService.getEquipmentAirconditionerAutomaticSummer("OFF");
//            for (int i = 0; i < listIdRadiator.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdRadiator.get(i), "OFF", 0);
//                System.out.println(listIdRadiator.get(i));
//            }
//
//            for (int i = 0; i < listIdAirconditioner.size(); i++) {
//                equipmentService.updateStatutAutomaticScreen(listIdAirconditioner.get(i), "ON", 4);
//                System.out.println(listIdAirconditioner.get(i));
//            }
//
//        }

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
