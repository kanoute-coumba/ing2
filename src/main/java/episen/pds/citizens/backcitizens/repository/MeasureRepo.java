package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Measure;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Repository
public interface MeasureRepo extends CrudRepository<Measure,Integer> {

    @Query(value = "select measure.* from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1 and sensor.type='capteur de luminosité' " +
            "            and timestamp = (select max(timestamp) from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1  and sensor.type='capteur de luminosité') limit 1", nativeQuery = true)
    Measure getLightStatInRoom(int id_room);

    @Query(value = "select measure.* from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1 and sensor.type='capteur de température' " +
            "            and timestamp = (select max(timestamp) from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1  and sensor.type='capteur de température') limit 1", nativeQuery = true)
    Measure getTempStatInRoom(int id_room);

    @Query(value = "select max(timestamp) from measure", nativeQuery = true)
    Timestamp getTimestamp();
}