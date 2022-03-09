package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.PeakDay;
import episen.pds.citizens.backcitizens.model.PeakMonth;
import episen.pds.citizens.backcitizens.model.PeakYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeakMonthRepo extends CrudRepository<PeakMonth, Integer> {

    @Query(value = " select extract(month from date) as month, count(*) as numberofpeak " +
            " from peakday where date between '2020-01-01' and '2020-12-31' group by (month) order by (month) ",  nativeQuery=true)

    public Iterable<PeakMonth> getPeak20();

    @Query(value = " select extract(month from date) as month, count(*) as numberofpeak " +
            " from peakday where date between '2021-01-01' and '2021-12-31' group by (month) order by (month) ",  nativeQuery=true)

    public Iterable<PeakMonth> getPeak21();

    @Query(value = " select extract(month from date) as month, count(*) as numberofpeak " +
            " from peakday where date between '2022-01-01' and '2022-12-31' group by (month) order by (month) ",  nativeQuery=true)

    public Iterable<PeakMonth> getPeak22();

}
