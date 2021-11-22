package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.ConsumptionByBuilding;
import episen.pds.citizens.backcitizens.model.ConsumptionByRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConsumptionRepo extends CrudRepository<Consumption, Integer> {

   // Optional<Consumption> findConsumptionByDate(String date);

    @Query(value = "select getConsumptionByBuilding(?1)", nativeQuery = true)
    Iterable<Consumption> findConsumptionByBuilding(int id_building);

    @Query(value = "select getConsumptionByRoom(?1)", nativeQuery = true)
    Iterable<Consumption> findConsumptionByRoom(int id_room);

    @Query(value = "select getConsumptionAllRooms();", nativeQuery = true)
    Iterable<ConsumptionByRoom> findConsumptionAllRooms();

    @Query(value = "select getConsumptionAllBuildings();", nativeQuery = true)
    Iterable<ConsumptionByBuilding> findConsumptionAllBuilding();
}
