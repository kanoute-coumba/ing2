package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EquipmentService {

    @Autowired
    EquipmentRepo equipmentRepo;

    public Iterable<Object> getEquipmentByConsumption(int id_building){
        return equipmentRepo.findByConsumption(id_building);
    }
}
