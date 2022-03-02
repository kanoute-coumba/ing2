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

    public List<Integer> getEquipmentAutomaticPresenceFalse (String statut, String sensor){
        System.out.println(equipmentRepo.getEquipmentAutomaticFalse(statut, sensor) + "service");
        return equipmentRepo.getEquipmentAutomaticFalse(statut, sensor);
    }

    public List<Integer> getEquipmentAutomaticPresenceTrue (String statut, String sensor){
        System.out.println(equipmentRepo.getEquipmentAutomaticTrue(statut, sensor) + "servicetrue");
        return equipmentRepo.getEquipmentAutomaticTrue(statut, sensor);
    }

    @Transactional
    public void updateHighValuesensor(Integer value, String sensor) {
        equipmentRepo.updateHighValue(value, sensor);
    }

    @Transactional
    public void updateLowValuesensor(Integer value, String sensor) {
        equipmentRepo.updateLowValue(value, sensor);
    }

    public Map<String, String> valuesensor(String date1, String date2) {
        return equipmentRepo.valueSensor(date1, date2);
    }



    //pas encore faire -- A faire!!

    public List<Integer> getEquipmentScreenAutomaticT (String statut) {
        return equipmentRepo.getEquipmentScreenAutomaticT(statut);
    }

    public List<Integer> getEquipmentScreenAutomaticF (String statut) {
        return equipmentRepo.getEquipmentScreenAutomaticF(statut);
    }

    public List<Integer> getEquipmentRadiatorAutomaticWinter(String statut) {
        return equipmentRepo.getEquipmentRadiatorAutomaticWinter(statut);
    }

    public List<Integer> getEquipmentRadiatorAutomaticSummer(String statut) {
        return  equipmentRepo.getEquipmentRadiatorAutomaticSummer(statut);
    }

    public List<Integer> getEquipmentAirconditionerAutomaticWinter(String statut) {
        return equipmentRepo.getEquipmentAircontionerAutomaticWinter(statut);
    }

    public List<Integer> getEquipmentAirconditionerAutomaticSummer(String statut) {
        return  equipmentRepo.getEquipmentAirconditionerAutomaticSummer(statut);
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
