package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EquipmentWithConsumptionRepo extends CrudRepository<EquipmentWithConsumption,Integer> {
    @Query(value= """
            SELECT equipment.id_equipment,equipment.id_room,equipment.type,c2.value from equipment inner join\s
            (select * from consumption\s
            where id_consumption in (Select max\s
            from (Select max(id_consumption),id_equipment\s
            from consumption group by id_equipment) as c1))\s
            as c2 on equipment.id_equipment=c2.id_equipment\s
            where id_room in (Select id_room from room\s
            where id_floor in (Select id_floor from floor where\s
            id_building= :idb )) order by c2.value""",nativeQuery = true)
    Iterable<EquipmentWithConsumption> findEquipmentByConsumptionByBuilding(@Param("idb") int id_b);
    @Query(value = """
            SELECT equipment.id_equipment,equipment.id_room,equipment.type,c2.value\s
            from equipment inner join (select * from consumption where id_consumption in
            (Select max from (Select max(id_consumption),id_equipment\s
            from consumption group by id_equipment) as c1)) as c2 on
            equipment.id_equipment=c2.id_equipment where id_room=:id_r order by c2.value""", nativeQuery = true)
    Iterable<EquipmentWithConsumption> findEquipmentWithConsumptionByRoom(@Param("id_r") int id_r);
}
