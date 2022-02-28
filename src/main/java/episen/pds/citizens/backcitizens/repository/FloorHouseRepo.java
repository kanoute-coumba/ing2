package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.equipments.FloorHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FloorHouseRepo extends JpaRepository<FloorHouse, Integer> {
    @Query(value = "select id_floor, name_floor,f.id_house from equipments.floor f inner join equipments.house on f.id_house=house.id_house where address=?1", nativeQuery = true)
    List<FloorHouse> findFloorByHouse(String email);

}
