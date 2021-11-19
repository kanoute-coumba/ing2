package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Equipment;

import episen.pds.citizens.backcitizens.repository.EquipmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    public Iterable<String> getEquipment(String typEquipment, String location) {
        return equipmentRepo.findByNameEquipment(typEquipment, location);
    }
}
