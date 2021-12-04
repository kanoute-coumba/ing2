package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepo extends CrudRepository<Equipment, Integer> {

    @Query( value = "select type From equipment e inner join room r on e.id_room = r.id_room where r.id_room =:id_room AND id_floor =:id_floor", nativeQuery = true)
    List<String> findByNameEquipment(@Param("id_room") Integer id_room, @Param("id_floor")Integer id_floor);

    @Query(value = "select type from equipment where id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    String equipLampe (@Param("id_room") Integer id_room , @Param("id_equipment") Integer id_equipment);

    @Query(value = "select type from equipment where id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    String equipClimatisation (@Param("id_room") Integer id_room , @Param("id_equipment") Integer id_equipment);

    @Query( value = "select type from equipment where id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    String equipRadiateur (@Param("id_room") Integer id_room , @Param("id_equipment") Integer id_equipment);

    @Query( value = "select type from equipment where id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    String equipFenetre (@Param("id_room") Integer id_room , @Param("id_equipment") Integer id_equipment);

    @Query( value = "select type from equipment where id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    String equipStore (@Param("id_room") Integer id_room , @Param("id_equipment") Integer id_equipment);

    @Query( value = "select type from equipment where id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    String equipScreen (@Param("id_room") Integer id_room , @Param("id_equipment") Integer id_equipment);

    @Query(value = "update equipment set statut =:statutLampe, type_mode =:type_mode  WHERE id_room =:id_room AND id_equipment =:id_equipment", nativeQuery = true)
    void updateStatutLampe(String statutLampe, String type_mode, Integer id_room, Integer id_equipment);



}
