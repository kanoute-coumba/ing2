package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.Equipment_Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {
    @Query(value = "select * from equipment where id_room=? order by id_equipment", nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom(int id_room);

    @Query(value = "select * from equipment order by id_room", nativeQuery = true)
    Iterable<Equipment> findEquipmentOrderByRoom();

    @Query(value = "select * from equipment where id_equipment=?1;", nativeQuery = true)
    Equipment findEquipmentById(int id_equipment);

    @Query(value = "select * from equipment_data " +
            "inner join equipment e on e.id_equipment = equipment_data.id_equipment_data " +
            "where id_room=?1 order by equipment_data.id_equipment_data", nativeQuery = true)
    Iterable<Equipment_Data> findEquipmentDataByRoom(int id_room);

    @Query(value = "select * from equipment_data " +
            "inner join equipment e on equipment_data.id_equipment_data = e.id_equipment" +
            " order by e.id_room;", nativeQuery = true)
    Iterable<Equipment_Data> findEquipmentDataOrderByRoom();

    @Query(value = "select * from equipment_data where id_equipment_data=?1;", nativeQuery = true)
    Equipment findEquipmentDataById(int id_equipment);

    @Nullable
    @Query(value = "select cast(setEquipmentValue(?1,?2) as varchar)", nativeQuery = true)
    void setEquipmentValue(int id_equipment, double value);

    @Nullable
    @Query(value = "select cast(setEquipmentAuto(?1) as varchar)", nativeQuery = true)
    void setEquipmentAuto(int id_equipment);

    @Nullable
    @Query(value = "select cast(setEquipmentManu(?1) as varchar)", nativeQuery = true)
    void setEquipmentManu(int id_equipment);

    @Nullable
    @Query(value = "select cast(setEquipmentOff(?1) as varchar)", nativeQuery = true)
    void setEquipmentOff(int id_equipment);

    @Nullable
    @Query(value = "select cast(setEquipmentOn(?1) as varchar)", nativeQuery = true)
    void setEquipmentOn(int id_equipment);

    @Query(value = "update equipment_data " +
            "set value = value + 1 ," +
            "statut = 'ON' " +
            "where id_equipment_data = ?1 " +
            "and value < 5", nativeQuery = true)
    void setEquipmentOneUp(int id_equipment);

    @Query(value = "update equipment_data " +
            "set value = value - 1 " +
            "where id_equipment_data = ?1 " +
            "and value < 0; update equipment_data set statut = 'OFF' where value = 0;", nativeQuery = true)
    void setEquipmentOneDown(int id_equipment);

    @Query(value = "select * from equipment_data where id_equipment_data=?1", nativeQuery = true)
    Equipment_Data findEquipment_DataById(int id_equipment);
}
