package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.repository.EquipmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    public Iterable<String> getEquipment(Integer id_room, Integer id_floor) {
        return equipmentRepo.findByNameEquipment(id_room, id_floor);
    }

    public Iterable<Equipment> getEquipmentBYRoom (Integer idr) {
        return  equipmentRepo.findEquipmentByRoom(idr);
    }

    @Transactional
    public void UpdateStatutMode (String chooseStatut, String type_mode, Integer id_equipment) {
        equipmentRepo.UpdateStatutMode(chooseStatut, type_mode, id_equipment);
    }

    @Transactional
    public void UpdateValueEquipment(Integer valueEquipment, Integer id_equipment) {
        equipmentRepo.UpdateValueEquipment(valueEquipment, id_equipment);
    }

    public String getNameRoomByIdroom (Integer id_room) {
        return equipmentRepo.findByNameRoom(id_room);
    }

    public String NameEquipment(Integer id_equipment) {
        return equipmentRepo.NameEquipment(id_equipment);
    }

    public Iterable<String> NameRoomByFloor (Integer id_floor) {
        return equipmentRepo.NameRoomByFloor(id_floor);
    }

    public Integer getIdRoom (String  name, Integer id_floor) {
        return equipmentRepo.getIdRoom(name, id_floor);
    }

    public Iterable<String> NameFloorByBuilding (Integer id_building) {
        return equipmentRepo.NameFloorByBuilding(id_building);
    }

    public Integer getIdFloor (String  name_floor, Integer id_building) {
        return equipmentRepo.getIdFloor(name_floor, id_building);
    }







//    public String recoverLampe (Integer id_room, Integer id_equipment) {
//        return equipmentRepo.equipLampe(id_room, id_equipment);
//    }
//
//    public String recoverClimatisation (Integer id_room, Integer id_equipment) {
//        return equipmentRepo.equipClimatisation(id_room, id_equipment);
//    }
//
//    public String recoverRadiateur (Integer id_room, Integer id_equipment) {
//        return equipmentRepo.equipRadiateur(id_room, id_equipment);
//    }
//
//    public String recoverFenetre (Integer id_room, Integer id_equipment) {
//        return equipmentRepo.equipFenetre(id_room, id_equipment);
//    }
//
//    public String recoverStore (Integer id_room, Integer id_equipment) {
//        return equipmentRepo.equipStore(id_room, id_equipment);
//    }
//
//    public String recoverScreen (Integer id_room, Integer id_equipment) {
//        return equipmentRepo.equipScreen(id_room, id_equipment);
//    }

//    public void updateStatutLampe(Equipment equipment) {
//        equipmentRepo.updateStatutLampe(equipment.getStatut(), equipment.getType_mode(), equipment.getId_room(), equipment.getId_equipment());
//
//    }

//    public void updateStatutLampe(String statutLampe, String type_mode, Integer id_room, Integer id_equipment) {
//        equipmentRepo.updateStatutLampe(statutLampe, type_mode, id_room, id_equipment);
//    }


}
