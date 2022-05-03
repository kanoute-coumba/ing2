package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.DWPbyBuilding;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DWPbyBuildingRepo extends CrudRepository<DWPbyBuilding, Integer> {

    @Transactional
    @Modifying
    @Query(value = "create table if not exists DWPbyBuilding as (select building.id_building, building.name_building, count(*) as nbreDWPs from building inner join workplace " +
            "on building.name_building=workplace.name_building " +
            "group by building.id_building, building.name_building order by building.name_building)" , nativeQuery = true)
    public void createDWPbuildings();

    @Query(value = " select * from DWPbyBuilding order by name_building" , nativeQuery = true)
    public Iterable<DWPbyBuilding> getDWPbuildings();

}
