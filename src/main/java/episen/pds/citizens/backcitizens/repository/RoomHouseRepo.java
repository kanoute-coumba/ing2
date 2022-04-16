package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomHouseRepo extends JpaRepository<Room, Integer> {
    @Query(value = "select r.id_room,r.name,r.id_floor from room r inner join floor f on r.id_floor = f.id_floor where r.id_floor=?1 and r.name IN ('Salon', 'Cuisine', 'Douche', 'Chambre') order by r.name ASC", nativeQuery = true)
    List<Room> findRoomByFloor(Integer floor);

    @Query(value = "select room from room inner join floor on" +
            " floor.id_floor=room.id_floor where id_building=?idb", nativeQuery = true)
    Iterable<Room> findRoomByIdBuilding(int idb);




}
