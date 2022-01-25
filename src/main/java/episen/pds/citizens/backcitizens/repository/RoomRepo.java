package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.equipments.Room;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface RoomRepo extends CrudRepository<Room, Integer>  {
/*    @Query(value = "${findRooms}", nativeQuery = true)
    Iterable<RoomsWithConsumption> findRoomsWithConsumption();*/
}
