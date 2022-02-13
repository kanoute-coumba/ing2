package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EquipmentWithConsumptionRepo extends CrudRepository<EquipmentWithConsumption,Integer> {
    @Query(value= """
            SELECT equipment.id_equipment,equipment.id_room,equipment.type,c2.value\s
             , date_time from equipment inner join
            (SELECT cs.id_equipment, cs.value FROM consumption cs
            WHERE date_time = (SELECT MAX(date_time) FROM consumption cs1
            GROUP BY cs1.id_equipment HAVING cs.id_equipment = cs1.id_equipment))
            as c2 on equipment.id_equipment=c2.id_equipment
            where id_room in (Select id_room from room
            where id_floor in (Select id_floor from floor where
            id_building=:idb )) order by c2.value""",nativeQuery = true)
    Iterable<EquipmentWithConsumption> findEquipmentByConsumptionByBuilding(@Param("idb") int id_b);
    @Query(value = """
            SELECT equipment.id_equipment,equipment.id_room,equipment.type,c2.value\s
             ,date_time from equipment inner join
            (SELECT cs.id_equipment, cs.value FROM consumption cs
            WHERE date_time = (SELECT MAX(date_time) FROM consumption cs1
            GROUP BY cs1.id_equipment HAVING cs.id_equipment = cs1.id_equipment))
            as c2 on equipment.id_equipment=c2.id_equipment
            where id_room=:id_r order by c2.value""", nativeQuery = true)
    Iterable<EquipmentWithConsumption> findEquipmentWithConsumptionByRoom(@Param("id_r") int id_r);
  }
