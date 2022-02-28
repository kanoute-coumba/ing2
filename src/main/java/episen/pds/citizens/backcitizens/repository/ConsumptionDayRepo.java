package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import episen.pds.citizens.backcitizens.model.PeakDay;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.util.annotation.Nullable;

import java.sql.Date;

@Repository
public interface ConsumptionDayRepo extends CrudRepository<ConsumptionDay, Date> {

    /* the consumption in whole day ! I get the value in Wat but,
    convert it on Watt by multiply it with a time factor (1 day = 86400s)
     */
    @Query(value = " with A as (select * from consumption where id_equipment " +
            " in (select id_equipment from equipment where id_room " +
            " in (select id_room from room where id_floor " +
            " in (select id_floor from floor where id_building " +
            " in (select id_building from building))))) " +
            " select to_timestamp(date_time)\\:\\:date as date, sum(value)*86400 as consoday " +
            " from A group by (date_time) order by date", nativeQuery=true)

    public Iterable<ConsumptionDay> findConsoPerDay();

    /* for each row, where conso is under than attribution in the same date,
    pick and save it in new table called overrunday.
    Then we have just to count all rows in overrunday,
    this represent day in wich we have overrun in the smartcity

    @Modifying
    @Query(value = " create table if not exists peakday as " +
            " SELECT t1.date, t1.consoday, t2.value, count(*) as numberofpeak " +
            " FROM consobyday t1 INNER JOIN attribution t2 " +
            " ON t1.date = t2.date where t1.consoday > t2.value " +
            "group by(t1.date,t2.value) order by (t1.date)", nativeQuery=true)

    public Iterable<ConsumptionDay> findPeakDay();
*/
}