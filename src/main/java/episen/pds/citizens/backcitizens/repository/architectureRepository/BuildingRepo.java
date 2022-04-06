package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface BuildingRepo extends JpaRepository<Building, Integer> {
    @Query(value = "select * from building WHERE type_building = 'Entreprise'", nativeQuery = true)
    List<Building> getAllBuildings();

    @Query(value = "Select * from Building where id_building in (Select id_building from userbuilding where id_user=:id_u)",
    nativeQuery = true)
    Iterable<Building> getBuildingByIdUser(@Param("id_u") int idu);

}

