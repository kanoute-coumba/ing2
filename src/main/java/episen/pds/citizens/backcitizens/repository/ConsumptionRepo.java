package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.ConsumptionByBuilding;
import episen.pds.citizens.backcitizens.model.ConsumptionByRoom;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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
            "  ,date_time from equipment inner join consumption on" +
            " equipment.id_equipment=consumption.id_equipment" +
            " Where equipment.id_equipment=:id_equip order by date_time",nativeQuery = true)
    Iterable<Consumption> findHistoryConsumptionByIdEquipment(@Param("id_equip") int id_equip);
    @Query(value = "Select consumption.id_consumption, equipment.id_equipment,consumption.value" +
            "  ,date_time from equipment inner join consumption on" +
            " equipment.id_equipment=consumption.id_equipment" +
            " Where equipment.id_equipment=:id_equip and " +
            "date_time<:date_end and date_time>:date_begin order by date_time",nativeQuery = true)
    Iterable<Consumption> findHistoryConsumptionByIdEquipmentBetweenTwoDate(@Param("id_equip") int id_equip,
                                                                                @Param("date_begin") long date_begin,
                                                                                @Param("date_end") long date_end);
    @Query(value = "Select consumption.id_consumption, equipment.id_equipment,consumption.value" +
            "  ,date_time from equipment inner join consumption on" +
            " equipment.id_equipment=consumption.id_equipment" +
            " Where equipment.id_room=:id_room and " +
            "date_time<:date_end and date_time>:date_begin order by date_time",nativeQuery = true)
    ArrayList<Consumption> findHistoryConsumptionByIdRoomBetweenTwoDate(@Param("id_room") int id_room,
                                                                        @Param("date_begin") long date_begin,
                                                                        @Param("date_end") long date_end);

    @Query(value = """
            SELECT c2.id_equipment,c2.value\s
             ,c2.date_time, c2.id_consumption from equipment inner join
            (SELECT * FROM consumption cs
            WHERE date_time = (SELECT MAX(date_time) FROM consumption cs1
            Where date_time <= :dBegin 
            GROUP BY cs1.id_equipment  
            HAVING cs.id_equipment = cs1.id_equipment))
            as c2 on equipment.id_equipment=c2.id_equipment
            where id_room=:id_r order by c2.date_time""", nativeQuery = true)
    ArrayList<Consumption> findEquipmentWithConsumptionByRoomBefore(@Param("id_r") int id_r, @Param("dBegin") long dBegin);
    @Query(value = "Select consumption.id_consumption, equipment.id_equipment,consumption.value" +
            "  ,date_time from equipment inner join consumption on" +
            " equipment.id_equipment=consumption.id_equipment " +
            "inner join room on room.id_room=equipment.id_room " +
            " Where room.id_floor=:idFloor and " +
            "date_time<:date_end and date_time>:date_begin order by date_time",nativeQuery = true)
    ArrayList<Consumption> findHistoryConsumptionByIdFloorBetweenTwoDate(@Param("idFloor") int id_floor,
                                                                        @Param("date_begin") long date_begin,
                                                                        @Param("date_end") long date_end);
    @Query(value = """
            SELECT c2.id_equipment,c2.value\s
             ,c2.date_time, c2.id_consumption from equipment inner join
            (SELECT * FROM consumption cs
            WHERE date_time = (SELECT MAX(date_time) FROM consumption cs1
            Where date_time <= :dBegin 
            GROUP BY cs1.id_equipment  
            HAVING cs.id_equipment = cs1.id_equipment))
            as c2 on equipment.id_equipment=c2.id_equipment
            inner join room on room.id_room=equipment.id_room
            where id_floor=:id_f order by c2.date_time""", nativeQuery = true)
    ArrayList<Consumption> findEquipmentWithConsumptionByFloorBefore(@Param("id_f") int id_f, @Param("dBegin") long dBegin);

    @Query(value = "Select consumption.id_consumption, equipment.id_equipment,consumption.value" +
            "  ,date_time from equipment inner join consumption on" +
            " equipment.id_equipment=consumption.id_equipment " +
            "inner join room on room.id_room=equipment.id_room " +
            "inner join floor on floor.id_floor=room.id_floor " +
            " Where floor.id_building=:idBuilding and " +
            "date_time<:date_end and date_time>:date_begin order by date_time",nativeQuery = true)
    ArrayList<Consumption> findHistoryConsumptionByIdBuildingBetweenTwoDate(@Param("idBuilding") int id_building,
                                                                         @Param("date_begin") long date_begin,
                                                                         @Param("date_end") long date_end);

    @Query(value = """
            SELECT c2.id_equipment,c2.value\s
             ,c2.date_time, c2.id_consumption from equipment inner join
            (SELECT * FROM consumption cs
            WHERE date_time = (SELECT MAX(date_time) FROM consumption cs1
            Where date_time <= :dBegin 
            GROUP BY cs1.id_equipment  
            HAVING cs.id_equipment = cs1.id_equipment))
            as c2 on equipment.id_equipment=c2.id_equipment
            inner join room on room.id_room=equipment.id_room
            inner join floor on floor.id_floor=room.id_floor
            where id_building=:id_b order by c2.date_time""", nativeQuery = true)
    ArrayList<Consumption> findEquipmentWithConsumptionByBuildingBefore(@Param("id_b") int id_b, @Param("dBegin") long dBegin);
}
