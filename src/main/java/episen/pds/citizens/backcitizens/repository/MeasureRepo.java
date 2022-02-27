package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Measure;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepo extends CrudRepository<Measure,Integer> {

    @Query(value = "select measure.* from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1 and sensor.type='capteur de luminosité' " +
            "            and timestamp = (select max(timestamp) from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1  and sensor.type='capteur de luminosité')", nativeQuery = true)
    Measure getLightStatInRoom(int id_room);

    @Query(value = "select measure.* from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1 and sensor.type='capteur de température' " +
            "            and timestamp = (select max(timestamp) from measure inner join sensor on measure.id_sensor=sensor.id_sensor " +
            "            inner join room on sensor.id_room=room.id_room " +
            "            where room.id_room=?1  and sensor.type='capteur de température')", nativeQuery = true)
    Measure getTempStatInRoom(int id_room);
}