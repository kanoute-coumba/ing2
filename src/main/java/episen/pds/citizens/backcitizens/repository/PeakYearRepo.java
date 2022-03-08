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

    @Query(value = " select extract(month from date) as mois, count(*) as numberofpeak " +
            " from peakday where date<='2020-12-31' group by (mois) order by (mois) ",  nativeQuery=true)

    public Iterable<PeakYear> getPeak20();

    @Query(value = " select extract(month from date) as mois, count(*) as numberofpeak " +
            " from peakday where date<='2021-12-31' group by (mois) order by (mois) ",  nativeQuery=true)

    public Iterable<PeakYear> getPeak21();

    @Query(value = " select extract(month from date) as mois, count(*) as numberofpeak " +
            " from peakday where date<='2022-12-31' group by (mois) order by (mois) ",  nativeQuery=true)

    public Iterable<PeakYear> getPeak22();

}
