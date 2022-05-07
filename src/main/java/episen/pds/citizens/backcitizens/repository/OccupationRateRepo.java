package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.OccupationRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRateRepo extends CrudRepository<OccupationRate, Integer> {

    @Query(value = " select year, avg(rate) as rate from OccupationRate group by year order by year ", nativeQuery=true)

    public Iterable<OccupationRate> getOccupationRate();
}
