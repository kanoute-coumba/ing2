package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConsumptionDayRepo extends CrudRepository<ConsumptionDay, Integer> {
    @Query(value = " create table if not exists consobyday as " +
            " with A as (select * from consumption where id_equipment " +
            " in (select id_equipment from equipment where id_room " +
            " in (select id_room from room where id_floor " +
            " in (select id_floor from floor where id_building " +
            " in (select id_building from building))))) " +
            " select cast(date_time as date), sum(value) as consoday " +
            " from A group by (date_time)", nativeQuery=true)

    public Iterable<ConsumptionDay> findConsoPerEquipementPerDay();

}