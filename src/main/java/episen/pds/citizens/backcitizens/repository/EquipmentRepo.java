package episen.pds.citizens.backcitizens.repository;




import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {

    @Query(value = "select id_equipment, id_room, type, statut, type_mode, value, e.id_equipment_data  from equipment eq inner join equipment_data e on eq.id_equipment=e.id_equipment_data where id_room =:idr", nativeQuery = true)
    Iterable<Map<String, String>> findEquipmentByRoom(@Param("idr") Integer idr);

    @Modifying
    @Query(value = "update equipment_data set statut =:chooseStatut, type_mode =:type_mode where id_equipment_data =:id_equipment", nativeQuery = true)
    void UpdateStatutMode(@Param("chooseStatut") String chooseStatut, @Param("type_mode") String type_mode, @Param("id_equipment") Integer id_equipment);

    @Query(value = "select name from room where id_room=:idr", nativeQuery = true)
    String findByNameRoom(@Param("idr") Integer idr);

    @Query(value = "select id_room from equipment where id_equipment =:id", nativeQuery = true)
    Integer findIdRoomByEquipment(@Param("id") Integer id);

    @Query(value = "select type from equipment where id_equipment =:id_equipment", nativeQuery = true)
    String NameEquipment(@Param("id_equipment") Integer id_equipment);

    @Query(value = "select * from equipment where id_room=? order by id_equipment", nativeQuery = true)
    Iterable<Equipment> findEquipmentByRoom(int id_room);

    @Query(value = "select * from equipment order by id_room", nativeQuery = true)
    Iterable<Equipment> findEquipmentOrderByRoom();

    @Modifying
    @Query(value = "update equipment_data set value =:valueEquipment where id_equipment_data =:id_equipment", nativeQuery = true)
    void UpdateValueEquipment(@Param("valueEquipment") Integer valueEquipment, @Param("id_equipment") Integer id_equipment);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in ( select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type =:sensor and m.value =:valuesensor) and e.type = 'lampe' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentAutomaticFalse (@Param("statut") String statut, @Param("sensor") String sensor, @Param("valuesensor") Integer valuesensor);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in ( select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type =:sensor and m.value =:valuesensor) and e.type = 'lampe' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentAutomaticTrue (@Param("statut") String statut, @Param("sensor") String sensor, @Param("valuesensor") Integer valuesensor);

//    @Modifying
//    @Query(value = "update measure m set value =:value where m.id_sensor in (select s.id_sensor from sensor s inner join measure m on s.id_sensor = m.id_sensor inner join room r on s.id_room = r.id_room inner join equipment e on e.id_room = r.id_room inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where s.type =:sensor and e.type ='lampe' and type_mode = 'Automatique' and (m.value > 0) AND (m.value <= 50))", nativeQuery = true)
//    void updateHighValue(@Param("value") Integer value, @Param("sensor") String sensor);

//    @Modifying
//    @Query(value = "update measure m set value =:value where m.id_sensor in (select s.id_sensor from sensor s inner join measure m on s.id_sensor = m.id_sensor inner join room r on s.id_room = r.id_room inner join equipment e on e.id_room = r.id_room inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where s.type =:sensor and e.type ='lampe' and type_mode = 'Automatique' and (m.value > 50) AND (m.value <= 100))", nativeQuery = true)
//    void updateLowValue(@Param("value") Integer value, @Param("sensor") String sensor);

    @Query(value = "select distinct m.value from room r inner join sensor s on r.id_room = s.id_room inner join measure m on m.id_sensor = s.id_sensor where r.name =:nameroom and type =:typesensor and m.timestamp between cast(:date1 as timestamp) and cast(:date2 as timestamp)", nativeQuery = true)
    Integer valueSensor(@Param("nameroom") String nameroom, @Param("typesensor") String typesensor, @Param("date1") String date1, @Param("date2") String date2);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in ( select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type = 'capteur de présence' and (m.value > 0) AND (m.value <= 50)) and e.type = 'télévision' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentScreenAutomaticT (@Param("statut") String statut);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in ( select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type = 'capteur de présence' and (m.value > 50) AND (m.value <= 100)) and e.type = 'télévision' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentScreenAutomaticF (@Param("statut") String statut);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in (select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type = 'capteur de temperature' and (m.value > -10) AND (m.value <= 15)) and e.type = 'radiateur' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentRadiatorAutomaticWinter(@Param("statut") String statut);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in (select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type = 'capteur de temperature' and (m.value > 15) AND (m.value <= 40)) and e.type = 'radiateur' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentRadiatorAutomaticSummer(@Param("statut") String statut);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in (select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type = 'capteur de temperature' and (m.value > -10) AND (m.value <= 15)) and e.type = 'climatisation' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentAircontionerAutomaticWinter(@Param("statut") String statut);

    @Query(value = "select e.id_equipment from equipment e inner join equipment_data eq on e.id_equipment = eq.id_equipment_data where id_room in (select s.id_room from room r inner join sensor s on r.id_room = s.id_room inner join measure m on  m.id_sensor = s.id_sensor where  s.type = 'capteur de temperature' and (m.value > 15) AND (m.value <= 40)) and e.type = 'climatisation' and type_mode = 'Automatique' and statut =:statut", nativeQuery = true)
    List<Integer> getEquipmentAirconditionerAutomaticSummer(@Param("statut") String statut);

    @Modifying
    @Query(value = "update equipment_data set statut =:statut, value=:value where id_equipment_data =:id_equipment_data", nativeQuery = true)
    void updateStatutAutomaticLight(@Param("id_equipment_data") Integer id_equipment_data, @Param("statut") String statut, @Param("value") Integer value);

    @Modifying
    @Query(value = "update equipment_data set statut =:statut, value=:value where id_equipment_data =:id_equipment_data", nativeQuery = true)
    void updateStatutAutomaticScreen(@Param("id_equipment_data") Integer id_equipment_data, @Param("statut") String statut, @Param("value") Integer value);

    @Modifying
    @Query(value = "update equipment_data set type_mode =:type_mode where id_equipment_data =:id_equipment", nativeQuery = true)
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
