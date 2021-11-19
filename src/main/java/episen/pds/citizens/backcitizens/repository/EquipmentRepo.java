package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {

    @Query( value = "select equip_name From equipement where type_equip =:typEquipment AND locations =:location", nativeQuery = true)
    List<String> findByNameEquipment(@Param("typEquipment") String typEquipment, @Param("location")String location);

}
