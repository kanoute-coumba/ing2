package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment_Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EquipmentDataRepo extends CrudRepository<Equipment_Data,Integer> {

    @Query(value = "select * from equipment_data where id_equipment_data=?1;", nativeQuery = true)
    Equipment_Data findAllById_equipment_data(int id_equipment);

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
    @Query(value = "select cast(setEquipmentOn( ?1 ) as varchar)", nativeQuery = true)
    void setEquipmentOn(int id_equipment);

    @Nullable
    @Modifying
    @Transactional
    @Query(value = "update equipment_data set value = value + 1 ,statut = 'ON' where id_equipment_data = ?1 and value < 5", nativeQuery = true)
    void setEquipmentOneUp(int id_equipment);

    @Nullable
    @Transactional
    @Modifying
    @Query(value = "update equipment_data " +
            "set value = value - 1 " +
            "where id_equipment_data = ?1 " +
            "and value > 0; update equipment_data set statut = 'OFF' where value = 0", nativeQuery = true)
    void setEquipmentOneDown(int id_equipment);
}
