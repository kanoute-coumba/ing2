package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.EquipmentAndData;
import episen.pds.citizens.backcitizens.model.Equipment_Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentAndDataRepo extends CrudRepository<EquipmentAndData,Integer> {

    @Query(value = "select id_equipment,type_mode,id_room,type,value,statut from equipment_data inner join equipment on " +
            "equipment.id_equipment=equipment_data.id_equipment_data where id_room=?1", nativeQuery = true)
    Iterable<EquipmentAndData> getEquipment_DataByIdRoom(int id_room);
}