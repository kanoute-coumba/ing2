package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {

    @Query(value = "select * from equipments.equipment eq inner join equipments.equipment_data e on eq.id_equipment=e.id_equipment_data where id_room =:idr", nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom(@Param("idr") Integer idr);

    @Modifying
    @Query(value = "update equipments.equipment_data set statut =:chooseStatut, type_mode =:type_mode where id_equipment_data =:id_equipment", nativeQuery = true)
    void UpdateStatutMode(@Param("chooseStatut") String chooseStatut, @Param("type_mode") String type_mode, @Param("id_equipment") Integer id_equipment);

    @Query(value = "select name from equipments.room where id_room=:idr", nativeQuery = true)
    String findByNameRoom(@Param("idr") Integer idr);

    @Query(value = "select id_room from equipments.equipment where id_equipment =:id", nativeQuery = true)
    Integer findIdRoomByEquipment(@Param("id") Integer id);

    @Query(value = "select type from equipments.equipment where id_equipment =:id_equipment", nativeQuery = true)
    String NameEquipment(@Param("id_equipment") Integer id_equipment);

    @Query(value = "select * from equipments.equipment where id_room=? order by id_equipment", nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom(int id_room);

    @Query(value = "select * from equipments.equipment order by id_room", nativeQuery = true)
    Iterable<Equipment> findEquipmentOrderByRoom();

    @Modifying
    @Query(value = "update equipments.equipment_data set value =:valueEquipment where id_equipment_data =:id_equipment", nativeQuery = true)
    void UpdateValueEquipment(@Param("valueEquipment") Integer valueEquipment, @Param("id_equipment") Integer id_equipment);

    @Query(value = "select e.id_equipment_data from equipments.equipment eq inner join equipments.equipment_data e on eq.id_equipment=e.id_equipment_data where type_mode ='Automatique' and statut =:statut and type = 'lampe';", nativeQuery = true)
    List<Integer> getEquipmentLampeAutomatic (@Param("statut") String statut);

    @Modifying
    @Query(value = "update equipments.equipment_data set statut =:statut, value=:value where id_equipment_data =:id_equipment_data", nativeQuery = true)
    void updateStatutAutomaticLight(@Param("id_equipment_data") Integer id_equipment_data, @Param("statut") String statut, @Param("value") Integer value);

    @Modifying
    @Query(value = "update equipments.equipment_data set type_mode =:type_mode where id_equipment_data =:id_equipment", nativeQuery = true)
    void updateStatutAuto (@Param("type_mode") String type_mode, @Param("id_equipment") Integer id_equipment);


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
}
