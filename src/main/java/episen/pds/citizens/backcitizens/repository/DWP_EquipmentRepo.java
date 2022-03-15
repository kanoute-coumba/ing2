package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.DWP_Equipment;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface DWP_EquipmentRepo extends CrudRepository<DWP_Equipment, Integer> {
    @Query(value = "select * from equipment where id_room=?1 order by id_equipment", nativeQuery = true)
    Iterable<DWP_Equipment> findEquipmentByRoom(int id_room);

    @Query(value = "select * from equipment order by id_room", nativeQuery = true)
    Iterable<DWP_Equipment> findEquipmentOrderByRoom();

    @Query(value = "select * from equipment where id_equipment=?1 ", nativeQuery = true)
    DWP_Equipment findEquipmentById(int id_equipment);

    @Query(value = "select * from equipment where id_equipment=?1 and type='capteur de luminosité'", nativeQuery = true)
    Iterable<DWP_Equipment> getActiveLightsEquipmentsInRoom(int id_room);
}
