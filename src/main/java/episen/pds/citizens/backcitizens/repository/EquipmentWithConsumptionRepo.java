package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EquipmentWithConsumptionRepo extends CrudRepository<EquipmentWithConsumption,Integer> {
    @Query(value= "select * from equipment inner join (Select max(id), value, id_equip from  consumption group by id_equip) on equipment.id=consumption.id_equip where id_room in (Select id_room from room where id_floor in (Select id_floor from floor where id_building= %:idb% )) order by consumption.value",nativeQuery = true)
    public Iterable<EquipmentWithConsumption> findEquipmentByConsumption(@Param("idb") int id_building);
}
