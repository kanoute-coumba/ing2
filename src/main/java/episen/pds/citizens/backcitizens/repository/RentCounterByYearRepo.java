package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.RentCounterByYear;
import episen.pds.citizens.backcitizens.model.Tenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentCounterByYearRepo extends CrudRepository<RentCounterByYear, Integer> {
    @Query(value = "select extract (year from date) as year, workplace.name_building, " +
            "count(*) as counter from workplace inner join tenant on workplace.id_space=tenant.id_space " +
            "group by year, workplace.name_building order by year, workplace.name_building", nativeQuery = true)
    public Iterable<RentCounterByYear> getCounterByYear();
}
