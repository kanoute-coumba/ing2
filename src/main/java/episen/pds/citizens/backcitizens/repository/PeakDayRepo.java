package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.PeakDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface PeakDayRepo extends CrudRepository<PeakDay, Date> {

    /*@Modifying
    @Query(value = " create table if not exists peakday as " +
            " SELECT t1.date, t1.consoday, t2.value, count(*) as numberofpeak " +
            " FROM consobyday t1 INNER JOIN attribution t2 " +
            " ON t1.date = t2.date where t1.consoday > t2.value " +
            "group by(t1.date,t2.value) order by (t1.date)", nativeQuery=true)

    public Iterable<PeakDay> findPeakDay();

     */
    @Query(value = " SELECT t1.date, t1.consoday, t2.value, count(*) as numberofpeak " +
            " FROM consobyday t1 INNER JOIN attribution t2 " +
            " ON t1.date = t2.date where t1.consoday > t2.value " +
            "group by(t1.date,t2.value) order by (t1.date)", nativeQuery=true)

    public Iterable<PeakDay> findPeakDay();

    /*@Query(value = " select extract(year from date) as year, count(*) as numberofpeak " +
            " from peakday group by (year) order by (year) ", nativeQuery=true)

    public Iterable<PeakDay> getPeak();

     */
}
