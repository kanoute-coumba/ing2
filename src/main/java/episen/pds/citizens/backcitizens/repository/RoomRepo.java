package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.model.RoomsWithConsumption;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface RoomRepo extends CrudRepository<Room, Integer>  {
    @Query(value = "select room.* from room inner join " +
            "equipment on equipment.id_room = room.id_room " +
            "where equipment.id_equipment = ?1 ;", nativeQuery = true)
    Room findRoomByEquipment(int id_equipment);

    @Query(value = "select room.* from room \n" +
            "inner join floor on room.id_floor = floor.id_floor\n" +
            "inner join building on building.id_building = floor.id_building\n" +
            "where type_building = 'Entreprise'", nativeQuery = true)
    Iterable<Room> findAllBusinessRoom();
/*    @Query(value = "${findRooms}", nativeQuery = true)
    Iterable<RoomsWithConsumption> findRoomsWithConsumption();*/
}
