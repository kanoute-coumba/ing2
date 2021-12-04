package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Condition;
import episen.pds.citizens.backcitizens.model.Configuration;
import episen.pds.citizens.backcitizens.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {
    @Query(nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom(int id_room);

}
