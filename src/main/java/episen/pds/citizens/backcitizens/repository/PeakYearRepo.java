package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.PeakDay;
import episen.pds.citizens.backcitizens.model.PeakYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeakYearRepo extends CrudRepository<PeakYear, Integer> {

    @Query(value = " select extract(year from date) as year, count(*) as numberofpeak " +
            " from peakday group by (year) order by (year) ", nativeQuery=true)

    public Iterable<PeakYear> getPeak();

}
