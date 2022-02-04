package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionDayRepo extends CrudRepository<ConsumptionDay, Integer> {
    @Query(value = " select consumption.id_consumption, consumption.value, " +
            "consumption.date_time, consumption.id_equipment, id_building" +
        " from consumption inner join (select * from room inner join equipment on equipment.id_room=room.id_room" +
        " inner join floor on floor.id_floor=room.id_floor)" +
        " as a1 on a1.id_equipment=consumption.id_equipment" +
        " where date_time between '2021-05-23 00:00:00' and '2021-05-23 23:59:59' order by id_equipment", nativeQuery=true)
    public Iterable<ConsumptionDay> findConsoPerEquipementPerDay();
}
/*
    conso de la ville pour une journée donnée

    with T as (select sum(value) as consoByBuilding, id_building
    from consumption inner join
        (select * from room inner join equipment on equipment.id_room=room.id_room
                inner join floor on floor.id_floor=room.id_floor)
    as a1 on a1.id_equipment=consumption.id_equipment
        where date_time between '2021-01-01 00:00:00' and '2021-12-31 23:59:59' group by (id_building))
        select sum(consoBybuilding) as totalConsoPerDay from T;

 */