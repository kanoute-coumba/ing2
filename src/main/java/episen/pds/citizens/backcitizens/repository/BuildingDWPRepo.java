package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.BuildingDWP;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDWPRepo extends CrudRepository<BuildingDWP, Integer> {
    @Query(value = "select building.id_building, building.name_building, count(*) from building inner join workplace " +
            "on building.name_building=workplace.name_building " +
            "group by building.id_building, building.name_building order by building.name_building" , nativeQuery = true)
    Iterable<BuildingDWP> getDWPbuildings();
}
