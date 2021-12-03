package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.repository.EquipmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    public Iterable<String> getEquipment(Integer id_room, Integer id_floor) {
        return equipmentRepo.findByNameEquipment(id_room, id_floor);
    }

    public String recoverLampe (Integer id_room, Integer id_equipment) {
        return equipmentRepo.equipLampe(id_room, id_equipment);
    }

    public String recoverClimatisation (Integer id_room, Integer id_equipment) {
        return equipmentRepo.equipClimatisation(id_room, id_equipment);
    }

    public String recoverRadiateur (Integer id_room, Integer id_equipment) {
        return equipmentRepo.equipRadiateur(id_room, id_equipment);
    }

    public String recoverFenetre (Integer id_room, Integer id_equipment) {
        return equipmentRepo.equipFenetre(id_room, id_equipment);
    }

    public String recoverStore (Integer id_room, Integer id_equipment) {
        return equipmentRepo.equipStore(id_room, id_equipment);
    }

    public String recoverScreen (Integer id_room, Integer id_equipment) {
        return equipmentRepo.equipScreen(id_room, id_equipment);
    }


}
