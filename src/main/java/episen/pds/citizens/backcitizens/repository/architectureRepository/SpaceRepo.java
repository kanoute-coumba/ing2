package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpaceRepo extends JpaRepository<Space, Integer> {
    @Query(value = "select * from space s JOIN floor f on f.id_floor = s.id_floor WHERE f.name_floor = ?1", nativeQuery = true)
    List<Space> getSpacesOfFloor(String name_floor);

    // Not yet
    @Query(value = "select * from space s JOIN floor f on f.id_floor = s.id_floor WHERE f.name_floor = ?1 AND s.type_space = ?2", nativeQuery = true)
    List<Space> getSpacesOfFloorByType(String name_floor, String type_space);

    // Not yet
    @Query(value = "select * from space s INNER JOIN floor f INNER JOIN building b WHERE f.id_floor = s.id_floor AND b.id_building = f.id_building AND b.type_building = 'Entreprise' AND b.name_building = ?1", nativeQuery = true)
    List<Space> getSpacesOfBuilding(String name_building);
}

