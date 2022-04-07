package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.model.equipments.*;
import episen.pds.citizens.backcitizens.repository.EquipmentRepo;
import episen.pds.citizens.backcitizens.repository.FloorHouseRepo;
import episen.pds.citizens.backcitizens.repository.HouseRepo;
import episen.pds.citizens.backcitizens.repository.RoomHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    HouseRepo houseRepo;
    @Autowired
    FloorHouseRepo floorRepo;
    @Autowired
    RoomHouseRepo roomHouseRepo;



    public Iterable<Map<String, String>> getEquipmentBYRoom(Integer idr) {


        return equipmentRepo.findEquipmentByRoom(idr);
    }

    @Transactional
    public void UpdateStatutMode(String chooseStatut, String type_mode, Integer id_equipment) {
        equipmentRepo.UpdateStatutMode(chooseStatut, type_mode, id_equipment);
    }

    @Transactional
    public void UpdateValueEquipment(Integer valueEquipment, Integer id_equipment) {
        equipmentRepo.UpdateValueEquipment(valueEquipment, id_equipment);
    }

    public String getNameRoomByIdroom(Integer id_room) {
        return equipmentRepo.findByNameRoom(id_room);
    }

    public String NameEquipment(Integer id_equipment) {
        return equipmentRepo.NameEquipment(id_equipment);
    }

    public Integer getIdRoomByEquipment(Integer id_equipment) {
        return equipmentRepo.findIdRoomByEquipment(id_equipment);
    }

    public List <Building> getHouseByEmail(String email) {
        System.out.println(houseRepo.findHouseByEmail(email));
        return houseRepo.findHouseByEmail(email);
    }

    public List<Floor> getFloors(String house) {
        return floorRepo.findFloorByHouse(house);
    }

    public List<Room> getRooms(String floor) {
        return roomHouseRepo.findRoomByFloor(Integer.parseInt(floor));
    }

    public List<Integer> getEquipmentAutomaticPresenceFalse (Integer id_room, String nameEquip){
        return equipmentRepo.getEquipmentAutomaticFalse(id_room, nameEquip);
    }

//    public List<Integer> getEquipmentAutomaticPresenceTrue (String statut, String sensor, Integer valuesensor){
//        return equipmentRepo.getEquipmentAutomaticTrue(statut, sensor, valuesensor);
//    }


    public Integer getCurrentlyValueSensor(Integer idroom, String currentdate) {
        return equipmentRepo.currentlyvalueofsensorPresence(idroom, currentdate);
    }

    public Integer presenceOrNotPresence(Integer id_room, String date, String typesensor) {
        return equipmentRepo.presenOrNotPrsence(id_room, date, typesensor);
    }
    public List<Integer> listIdroom(String typeSensor) {
        return equipmentRepo.listIdroom(typeSensor);
    }

    public String verifyStatutEquipment(Integer id_room) {
        return equipmentRepo.getStatutEquipment(id_room);
    }


    @Transactional
    public void updateStatutAutomaticScreen (Integer id_equipment_data, String statut, Integer value) {
        equipmentRepo.updateStatutAutomaticScreen(id_equipment_data, statut, value);
    }

    @Transactional
    public void updateStatutAutomaticLight (Integer id_equipment_data, String statut, Integer value) {
        equipmentRepo.updateStatutAutomaticLight(id_equipment_data, statut, value);
    }

    @Transactional
    public void updateStatutAuto (String type_mode,  Integer id_equipment) {
        equipmentRepo.updateStatutAuto(type_mode, id_equipment);
    }

}
