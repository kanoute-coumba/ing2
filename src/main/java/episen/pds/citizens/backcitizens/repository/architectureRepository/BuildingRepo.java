package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface BuildingRepo extends JpaRepository<Building, Integer> {
    @Query(value = "select * from building WHERE type_building = 'Entreprise'", nativeQuery = true)
    List<Building> getAllBuildings();
}

