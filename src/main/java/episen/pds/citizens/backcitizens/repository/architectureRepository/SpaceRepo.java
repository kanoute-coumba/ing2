package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SpaceRepo extends JpaRepository<Space, Integer> {
    @Query(value = "select * from space s JOIN floor f on f.id_floor = s.id_floor WHERE f.name_floor = ?1 ORDER BY s.id_space", nativeQuery = true)
    List<Space> getSpacesOfFloor(String name_floor);

    @Query(value = "select * from space s JOIN floor f on f.id_floor = s.id_floor WHERE f.name_floor = ?1 AND s.type_space = ?2 ORDER BY s.id_space", nativeQuery = true)
    List<Space> getSpacesOfFloorByType(String name_floor, String type_space);

    @Query(value = "select * from space WHERE name_space = ?1", nativeQuery = true)
    Optional<Space> getSpaceByName(String name_space);

}

