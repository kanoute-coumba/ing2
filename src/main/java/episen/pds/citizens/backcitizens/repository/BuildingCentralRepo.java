package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.BuildingCentral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingCentralRepo extends CrudRepository<BuildingCentral, Integer> {
    @Query(value = """
            SELECT bu.id_building, bu.address, bu.name_building, bu.type_building,
                  SUM(ce.max_capacity) as max_capacity,
                  SUM(pr.capacity) as capacity
           FROM building bu, production pr, central ce
           WHERE bu.type_building IN ( 'solaire', 'eolienne', 'hydraulique', 'thermique')
           AND pr.date_time = (SELECT MAX(date_time)
                             FROM production pr1
                             GROUP BY pr1.id_central
                             HAVING pr.id_central = pr1.id_central)
           AND pr.id_central = ce.id_central
           AND ce.id_building = bu.id_building
           GROUP BY bu.id_building;""",nativeQuery = true)
    List<BuildingCentral> readBuildingsTypeCentral();
}