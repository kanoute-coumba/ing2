package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.equipments.Room;
import episen.pds.citizens.backcitizens.model.equipments.RoomHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomHouseRepo extends JpaRepository<Room, Integer> {
    @Query(value = "select r.id_room,r.name,r.id_floor from room r inner join floor f on r.id_floor = f.id_floor where r.id_floor=?1", nativeQuery = true)
    List<Room> findRoomByFloor(Integer floor);




}
