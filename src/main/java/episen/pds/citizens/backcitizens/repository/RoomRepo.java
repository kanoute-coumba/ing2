package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.model.RoomsWithConsumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepo extends CrudRepository<Room, Integer>  {
//    @Query(nativeQuery = true)
//    Iterable<RoomsWithConsumption> findRoomsWithConsumption();
}
