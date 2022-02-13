package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.ConsumptionByBuilding;
import episen.pds.citizens.backcitizens.model.ConsumptionByRoom;
import episen.pds.citizens.backcitizens.model.EquipmentWithConsumption;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface ConsumptionRepo extends CrudRepository<Consumption, Integer> {

    @Query(value = "select getConsumptionByBuilding(?1)", nativeQuery = true)
    Iterable<Consumption> findConsumptionByBuilding(int id_building);

    @Query(value = "select getConsumptionByRoom(?1)", nativeQuery = true)
    Iterable<Consumption> findConsumptionByRoom(int id_room);

    @Query(value = "select getConsumptionAllRooms();", nativeQuery = true)
    Iterable<ConsumptionByRoom> findConsumptionAllRooms();

    @Query(value = "select getConsumptionAllBuildings();", nativeQuery = true)
    Iterable<ConsumptionByBuilding> findConsumptionAllBuilding();

    @Query(value = "Select consumption.id_consumption, equipment.id_equipment,consumption.value" +
            "  ,date_time from equipment inner join" +
            " equipment.id_equipment=consumption.id_equipment" +
            " Where equipment.id_equipment=: id_equip",nativeQuery = true)
    Iterable<Consumption> findHistoryEquipmentWithConsumptionById(@Param("id_equip") int id_equip);
    @Query(value = "Select consumption.id_consumption, equipment.id_equipment,consumption.value" +
            "  ,date_time from equipment inner join" +
            " equipment.id_equipment=consumption.id_equipment" +
            " Where equipment.id_equipment=: id_equip and " +
            "date_time<:date_end and date_time>:date_begin",nativeQuery = true)
    Iterable<Consumption> findHistoryEquipmentWithConsumptionByIdBetweenTwoDate(@Param("id_equip") int id_equip,
                                                                                @Param("date_begin") String date_begin,
                                                                                @Param("date_end") String date_end);

}
