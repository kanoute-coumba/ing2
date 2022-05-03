package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.OccupationRate;
import episen.pds.citizens.backcitizens.model.PeakYear;
import episen.pds.citizens.backcitizens.model.RateXtraction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRateRepo extends CrudRepository<OccupationRate, Integer> {

    @Query(value = " select * from OccupationRate", nativeQuery=true)

    public Iterable<OccupationRate> getOccupationRate();
}
