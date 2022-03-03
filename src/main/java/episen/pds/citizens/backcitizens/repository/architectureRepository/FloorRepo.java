package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FloorRepo extends JpaRepository<Floor, Integer> {
    @Query(value = "select * from floor f JOIN building b on f.id_building = b.id_building WHERE type_building = 'Entreprise' and name_building = ?1", nativeQuery = true)
    List<Floor> getFloorsOfBuilding(String name_building);

    @Query(value = "select id_design from floor WHERE name_floor = ?1", nativeQuery = true)
    String getDesignOfFloor(String name_floor);

}

