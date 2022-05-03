package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.OccupationRate;
import episen.pds.citizens.backcitizens.model.PeakYear;
import episen.pds.citizens.backcitizens.model.RateXtraction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRateRepo extends CrudRepository<OccupationRate, Integer> {

    /*@Query(value = " select year, avg(rate) as rate from OccupationRate group by year order by year ", nativeQuery=true)

    public Iterable<OccupationRate> getOccupationRate();*/

    @Query(value = " select * from OccupationRate where year=2020", nativeQuery=true)

    public Iterable<OccupationRate> get2020Rate();

    @Query(value = " select * from OccupationRate where year=2021", nativeQuery=true)

    public Iterable<OccupationRate> get2021Rate();

    @Query(value = " select * from OccupationRate where year=2022", nativeQuery=true)

    public Iterable<OccupationRate> get2022Rate();
}
