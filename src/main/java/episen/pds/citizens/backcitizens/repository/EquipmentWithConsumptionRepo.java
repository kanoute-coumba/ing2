package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EquipmentWithConsumptionRepo extends CrudRepository<EquipmentWithConsumption,Integer> {
    @Query(value= "select * from equipment inner join \n" +
            "(select * from consumption \n" +
            "where id_consumption in (Select max \n" +
            "from (Select max(id_consumption),id_equipment \n" +
            "from consumption group by id_equipment) as c1)) \n" +
            "as c2 on equipment.id_equipment=c2.id_equipment \n" +
            "where id_room in (Select id_room from room \n" +
            "where id_floor in (Select id_floor from floor where \n" +
            "id_building= %:idb% )) order by c2.value",nativeQuery = true)
    public Iterable<EquipmentWithConsumption> findEquipmentByConsumption(@Param("idb") int id_building);
}
