package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.ConsumptionByBuilding;
import episen.pds.citizens.backcitizens.model.ConsumptionByRoom;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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

    @Query(value = "select consumption.* from consumption " +
            "inner join equipment on consumption.id_equipment = equipment.id_equipment " +
            "inner join room on equipment.id_room = room.id_room " +
            "Where room.id_room = ?1 " +
            "and consumption.date_time > current_date - INTEGER '1';", nativeQuery = true)
    Iterable<Consumption> getConsumptionByRoomFromYesterday(int id_room);

    @Query(value = "select consumption.* from consumption " +
            "inner join equipment on consumption.id_equipment = equipment.id_equipment " +
            "inner join room on equipment.id_room = room.id_room " +
            "Where room.id_room = ?1 " +
            "and consumption.date_time >= date_trunc('month', current_date - interval '1' month); ", nativeQuery = true)
    Iterable<Consumption> getConsumptionByRoomFromLastMonth(int id_room);
    @Query(value = "select consumption.* from consumption\n" +
            "inner join equipment on consumption.id_equipment = equipment.id_equipment\n" +
            "inner join room on equipment.id_room = room.id_room\n" +
            "Where room.id_room = 1\n" +
            "and consumption.date_time >= date_trunc('month', current_date - interval '1' year)", nativeQuery = true)
    Iterable<Consumption> getConsumptionByRoomFromLastYear(int id_room);


    @Query(value = "select consumption.* from consumption\n" +
            "inner join equipment on consumption.id_equipment = equipment.id_equipment\n" +
            "inner join room on equipment.id_room = room.id_room\n" +
            "inner join floor_dwp on room.id_floor = floor_dwp.id_floor\n" +
            "inner join company on floor_dwp.id_company = company.id_company\n" +
            "where company.id_company = ?1\n" +
            "and consumption.date_time >= date_trunc('month', current_date - interval '1' year);", nativeQuery = true)
    Iterable<Consumption> getConsumptionByCompanyFromLastYear(int id_room);

    @Query(value = "select consumption.* from consumption\n" +
            "inner join equipment on consumption.id_equipment = equipment.id_equipment\n" +
            "inner join room on equipment.id_room = room.id_room\n" +
            "inner join floor_dwp on room.id_floor = floor_dwp.id_floor\n" +
            "inner join company on floor_dwp.id_company = company.id_company\n" +
            "where company.id_company = ?1\n" +
            "and consumption.date_time >= date_trunc('month', current_date - interval '1' month);", nativeQuery = true)
    Iterable<Consumption> getConsumptionByCompanyFromLastMonth(int id_room);

    @Query(value = "select consumption.* from consumption\n" +
            "inner join equipment on consumption.id_equipment = equipment.id_equipment\n" +
            "inner join room on equipment.id_room = room.id_room\n" +
            "inner join floor_dwp on room.id_floor = floor_dwp.id_floor\n" +
            "inner join company on floor_dwp.id_company = company.id_company\n" +
            "where company.id_company = ?1\n" +
            "and consumption.date_time > current_date - INTEGER '1';", nativeQuery = true)
    Iterable<Consumption> getConsumptionByCompanyFromYesterday(int id_room);
}
