package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import episen.pds.citizens.backcitizens.model.equipments.FloorHouse;
import episen.pds.citizens.backcitizens.model.equipments.House;
import episen.pds.citizens.backcitizens.model.equipments.RoomHouse;
import episen.pds.citizens.backcitizens.repository.EquipmentRepo;
import episen.pds.citizens.backcitizens.repository.FloorHouseRepo;
import episen.pds.citizens.backcitizens.repository.HouseRepo;
import episen.pds.citizens.backcitizens.repository.RoomHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    public Iterable<Equipment> getEquipmentBYRoom(Integer idr) {
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

    public List<House> getHouseByEmail(String email) {
        return houseRepo.findHouseByEmail(email);
    }

    public List<FloorHouse> getFloors(String house) {
        return floorRepo.findFloorByHouse(house);
    }

    public List<RoomHouse> getRooms(String floor) {
        return roomHouseRepo.findRoomByFloor(Integer.parseInt(floor));
    }

    public List<Integer> getEquipmentLampeAutomatic (String statut){
        return equipmentRepo.getEquipmentLampeAutomatic(statut);
    }

    @Transactional
    public void updateStatutAutomaticLight (Integer id_equipment_data, String statut, Integer value) {
        equipmentRepo.updateStatutAutomaticLight(id_equipment_data, statut, value);
    }

    @Transactional
    public void updateStatutAuto (String type_mode,  Integer id_equipment) {
        equipmentRepo.updateStatutAuto(type_mode, id_equipment);
        //System.out.println(type_mode + "type_mode");
    }
}
