package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Configuration;
import episen.pds.citizens.backcitizens.model.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {}
