package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.equipments.RoomHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomHouseRepo extends JpaRepository<RoomHouse, Integer> {
    @Query(value = "select r.id_room,r.name,r.id_floor from equipments.room r inner join equipments.floor f on r.id_floor = f.id_floor where r.id_floor=?1", nativeQuery = true)
    List<RoomHouse> findRoomByFloor(Integer floor);




}
