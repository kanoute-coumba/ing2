package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import episen.pds.citizens.backcitizens.repository.EquipmentWithConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EquipmentService {

    @Autowired
    EquipmentWithConsumptionRepo equipmentWithConsumptionRepo;

    public Iterable<EquipmentWithConsumption> getEquipmentByConsumption(int id_building){
        return equipmentWithConsumptionRepo.findEquipmentByConsumption(id_building);
    }
}
