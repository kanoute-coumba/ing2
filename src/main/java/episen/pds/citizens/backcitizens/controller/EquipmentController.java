package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
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
        System.out.println(email);
        System.out.println(equipmentService.getHouseByEmail(email));
        return equipmentService.getHouseByEmail(email);
    }

    @GetMapping("/floor")
    public List<Floor> getFloors(@RequestParam("house") Integer house) {
        System.out.println(house);
        System.out.println(equipmentService.getFloors(house));
        return equipmentService.getFloors(house);
    }

    @GetMapping("/room")
    public List<Room> getRooms(@RequestParam("floor") String floor) {
        System.out.println(floor);
        return equipmentService.getRoomsByIdFloor(floor);
    }


    @PutMapping("/updateAuto")
    public void updateStatutAuto(@RequestParam("type_mode") String type_mode, @RequestParam("id_equipment") Integer id_equipment) {
        equipmentService.updateStatutAuto(type_mode, id_equipment);
    }

    @GetMapping("/valuepresence")
    public Integer getCurrentlyValueSensor(@RequestParam("idroom") Integer idroom, @RequestParam("currentdate") String currentdate) {
        return equipmentService.getCurrentlyValueSensor(idroom, currentdate);
    }

    @GetMapping("/updateHoursBeginAndEnd")
    public void updateHoursBeginAndEnd(@RequestParam("begin_time") String begin_time, @RequestParam("end_time") String end_time, @RequestParam("id_equipment_data") Integer id_equipment_data) {
        equipmentService.updateTimeWorkEquipment(begin_time, end_time, id_equipment_data);
    }


    @GetMapping("/updateAutoEquip")
    public String updateAutomatic(@RequestParam("meeting_time") String meeting_time, @RequestParam("id_building") Integer id_building) throws InterruptedException {


        hours = Timestamp.valueOf(meeting_time);
        System.out.println(hours);



        if ((hours.after(Timestamp.valueOf("2022-01-01 00:00:00")) && hours.before(Timestamp.valueOf("2022-01-01 23:00:00")))) {

            List<Integer> listRoomID = equipmentService.listIdroom("capteur de présence", id_building);
            for (int i = 0; i < listRoomID.size(); i++) {
//                System.out.println("id_room:" + listRoomID.get(i));
//                System.out.println("meeting_time:" + meeting_time);
                Integer sensorvalue = equipmentService.presenceOrNotPresence(listRoomID.get(i), meeting_time, "capteur de présence");
//                System.out.println("la value du sensor" + sensorvalue + "pour la room" + listRoomID.get(i));

                if (sensorvalue == 0) {
                    List<Integer> id_equipment_data_false = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomID.get(i), "lampe");
//                    System.out.println("la liste des équipements if: " + id_equipment_data_false);
                    for (int j = 0; j < id_equipment_data_false.size(); j++) {
                        equipmentService.updateStatutAutomaticLight(id_equipment_data_false.get(j), "OFF", 0);
//                        System.out.println(id_equipment_data_false.get(j) + "  est passé à OFF et value 0");
                    }
                } else if (sensorvalue == 1) {
                    List<Integer> id_equipment_data_false = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomID.get(i), "lampe");
//                    System.out.println("la liste des équipements else if: " + id_equipment_data_false);
                    for (int j = 0; j < id_equipment_data_false.size(); j++) {

                        equipmentService.updateStatutAutomaticLight(id_equipment_data_false.get(j), "ON", 1);
//                        System.out.println(id_equipment_data_false.get(j) + "  est passé à ON et value 1");
                    }
                }
            }

            //Gestion des équipements influencés par le capteur de température
            List<Integer> listRoomIDForTemp = equipmentService.listIdroom("capteur de température", id_building);
            for (int i = 0; i < listRoomIDForTemp.size(); i++) {
                Integer sensorvalue = equipmentService.presenceOrNotPresence(listRoomID.get(i), meeting_time, "capteur de température");
//                System.out.println("la value du sensor" + sensorvalue + listRoomID.get(i));

                if (sensorvalue <= 10) {
                    List<Integer> id_equipRadiateur = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForTemp.get(i), "radiateur");
                    List<Integer> id_equipClimatiseur = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForTemp.get(i), "climatisation");

                    for (int j = 0; j < id_equipRadiateur.size(); j++) {
                        equipmentService.updateStatutAutomaticLight(id_equipRadiateur.get(j), "ON", 1);
                    }

                    for (int k = 0; k < id_equipClimatiseur.size(); k++) {
                        equipmentService.updateStatutAutomaticLight(id_equipClimatiseur.get(k), "OFF", 0);
                    }
                } else if (sensorvalue > 10 && sensorvalue <= 18) {
                    List<Integer> id_equipRadiateur = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForTemp.get(i), "radiateur");
                    List<Integer> id_equipClimatiseur = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForTemp.get(i), "climatisation");

                    for (int j = 0; j < id_equipRadiateur.size(); j++) {
                        equipmentService.updateStatutAutomaticLight(id_equipRadiateur.get(j), "OFF", 0);
                    }

                    for (int k = 0; k < id_equipClimatiseur.size(); k++) {
                        equipmentService.updateStatutAutomaticLight(id_equipClimatiseur.get(k), "ON", 1);
                    }
                } else if (sensorvalue > 19 && sensorvalue <= 30) {
                    List<Integer> id_equipRadiateur = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForTemp.get(i), "radiateur");
                    List<Integer> id_equipClimatiseur = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForTemp.get(i), "climatisation");

                    for (int j = 0; j < id_equipRadiateur.size(); j++) {
                        equipmentService.updateStatutAutomaticLight(id_equipRadiateur.get(j), "OFF", 0);
                    }
                    for (int k = 0; k < id_equipClimatiseur.size(); k++) {
                        equipmentService.updateStatutAutomaticLight(id_equipClimatiseur.get(k), "ON", 2);
                    }
                }
            }

            //Gestion des équipements influencés par le capteur de luminosité
            List<Integer> listRoomIDForLuminosity = equipmentService.listIdroom("capteur de luminosité", id_building);
            for (int i = 0; i < listRoomIDForLuminosity.size(); i++) {
                Integer sensorvalue = equipmentService.presenceOrNotPresence(listRoomID.get(i), meeting_time, "capteur de luminosité");
//                System.out.println("la value du sensor" + sensorvalue);

                if (sensorvalue < 0) {
                    System.out.println("la valeur du sensor dans le iflumi " + sensorvalue);
                    List<Integer> id_equipmentStore = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForLuminosity.get(i), "store");
                    List<Integer> id_equipmentFenetre = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForLuminosity.get(i), "fenêtre");
                    List<Integer> id_equipmentLight = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForLuminosity.get(i), "lampe");
                    for (int j = 0; j < id_equipmentLight.size(); j++) {
                        equipmentService.updateStatutAutomaticLight(id_equipmentLight.get(j), "ON", 2);
//                        System.out.println(id_equipmentLight.get(j) + "  est passé à OFF et value 0");
                    }

                    for (int k = 0; k < id_equipmentStore.size(); k++) {
                        equipmentService.updateStatutAutomaticLight(id_equipmentStore.get(k), "OFF", 0);
                    }
                    for (int m = 0; m < id_equipmentFenetre.size(); m++) {
                        equipmentService.updateStatutAutomaticLight(id_equipmentFenetre.get(m), "OFF", 0);
                    }


                } else if (sensorvalue > 100 && sensorvalue <= 200) {
//                    System.out.println("la valeur du sensor lumi " + sensorvalue);
                    List<Integer> id_equipmentStore = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForLuminosity.get(i), "store");
                    List<Integer> id_equipmentFenetre = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForLuminosity.get(i), "fenêtre");
                    List<Integer> id_equipment_data_false = equipmentService.getEquipmentAutomaticPresenceFalse(listRoomIDForLuminosity.get(i), "lampe");

                    for (int j = 0; j < id_equipmentStore.size(); j++) {
                        equipmentService.updateStatutAutomaticLight(id_equipmentStore.get(j), "ON", 1);
//                        System.out.println(id_equipmentStore.get(j) + "est passé à OFF et value 0");
                        String statut = equipmentService.verifyStatutEquipment(listRoomIDForLuminosity.get(i));


                        if (statut.contains("OFF") || statut.contains("En veille") || statut.contains("transparent")) {
                            for (int k = 0; k < id_equipmentFenetre.size(); k++) {
                                equipmentService.updateStatutAutomaticLight(id_equipmentFenetre.get(k), "ON", 1);
                            }
                        }
                    }

                }

            }

            //Gestion de l'automatisation du lave-linge, sèche-linge

            List<Integer> listRoom = equipmentService.listRoomWithDryerLine("sèche-linge", "Automatique", 11534);
            System.out.println(listRoom);
            for (int i = 0; i < listRoom.size(); i++) {
                System.out.println(listRoom.get(i));
                List<Integer> id_equipment_data_false = equipmentService.getEquipmentAutomaticPresenceFalse(listRoom.get(i), "sèche-linge");
                for (int j = 0; j < id_equipment_data_false.size(); j++) {
                    Timestamp begin_time = equipmentService.getBeginTime(id_equipment_data_false.get(j));
                    Timestamp end_time = equipmentService.getEndTime(id_equipment_data_false.get(j));


                    if (hours.after(begin_time) && hours.before(end_time)) {
                        equipmentService.updateStatutAutomaticLight(id_equipment_data_false.get(j), "ON", 3);
                        System.out.println("L'équipement: " + id_equipment_data_false.get(j) + "est passé à ON");

                    } else {
                        equipmentService.updateStatutAutomaticLight(id_equipment_data_false.get(j), "OFF", 0);
                        System.out.println("L'équipemnt: " + id_equipment_data_false.get(j) + " est OFF");
                    }
                }
            }
        }

        return meeting_time;
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
