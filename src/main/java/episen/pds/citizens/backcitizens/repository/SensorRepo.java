package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Sensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepo extends CrudRepository<Sensor,Integer> {

    @Query(value = "select * from sensor where id_room=?1 limit 1", nativeQuery = true)
    Sensor getSensorInRoom(int id_room);

    @Query(value = "select * from sensor where id_room=?1 and type='capteur de luminosité' limit 1", nativeQuery = true)
    Sensor getLightSensorInRoom(int id_room);

    @Query(value = "select * from sensor where id_room=?1 and type='capteur de température' limit 1", nativeQuery = true)
    Sensor getTempSensorInRoom(int id_room);
}
