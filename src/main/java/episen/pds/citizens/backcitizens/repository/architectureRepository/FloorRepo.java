package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FloorRepo extends JpaRepository<Floor, Integer> {
    @Query(value = "select * from floor f JOIN building b on f.id_building = b.id_building WHERE type_building = 'Entreprise' and name_building = ?1", nativeQuery = true)
    List<Floor> getFloorsOfBuilding(String name_building);
}

