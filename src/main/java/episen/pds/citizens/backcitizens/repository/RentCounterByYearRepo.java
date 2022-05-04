package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.RentCounterByYear;
import episen.pds.citizens.backcitizens.model.Tenant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RentCounterByYearRepo extends CrudRepository<RentCounterByYear, Integer> {

    @Transactional
    @Modifying
    @Query(value = " create table if not exists RentCounterByYear as (select extract (year from date) as year, workplace.name_building, " +
            "count(*) as counter from workplace inner join tenant on workplace.id_space = tenant.id_space " +
            "group by year, workplace.name_building order by year, workplace.name_building)", nativeQuery = true)
    public void createRentCounterByYear();

    @Query(value = " select * from RentCounterByYear ", nativeQuery = true)
    public Iterable<RentCounterByYear> getRentCounterByYear();
}
