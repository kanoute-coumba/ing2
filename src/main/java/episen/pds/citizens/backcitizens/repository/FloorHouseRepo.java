package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.model.equipments.FloorHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FloorHouseRepo extends JpaRepository<Floor, Integer> {
    @Query(value = "select id_floor, name_floor, id_design, f.id_building from floor f inner join building on f.id_building=building.id_building where address=?1  order by name_floor ASC", nativeQuery = true)
    List<Floor> findFloorByHouse(String email);

}
