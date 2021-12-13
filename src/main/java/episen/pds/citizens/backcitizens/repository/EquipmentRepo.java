package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {

    @Query( value = "select type From equipment e inner join room r on e.id_room = r.id_room where r.id_room =:id_room AND id_floor =:id_floor", nativeQuery = true)
    List<String> findByNameEquipment(@Param("id_room") Integer id_room, @Param("id_floor")Integer id_floor);

    @Query(value = "select * from equipment where id_room =:idr", nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom (@Param("idr") Integer idr);

    @Modifying
    @Query(value = "update equipment set statut =:chooseStatut, type_mode =:type_mode where id_equipment =:id_equipment",nativeQuery = true )
    void UpdateStatutMode (@Param("chooseStatut") String chooseStatut, @Param("type_mode") String type_mode, @Param("id_equipment") Integer id_equipment);

    @Query(value = "select name from room where id_room=:idr", nativeQuery = true)
    String findByNameRoom(@Param("idr") Integer idr);

    @Query(value = "select type from equipment where id_equipment =:id_equipment", nativeQuery = true)
    String NameEquipment (@Param("id_equipment") Integer id_equipment);

    @Query(value="select * from equipment where id_room=? order by id_equipment", nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom(int id_room);

    @Query(value="select * from equipment order by id_room", nativeQuery = true)
    Iterable<Equipment> findEquipmentOrderByRoom();

    @Modifying
    @Query(value = "update equipment set value =:valueEquipment where id_equipment =:id_equipment", nativeQuery = true)
    void UpdateValueEquipment (@Param("valueEquipment") Integer valueEquipment, @Param("id_equipment") Integer id_equipment);

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
