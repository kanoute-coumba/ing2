package episen.pds.citizens.backcitizens.model.equipments;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "equipment_data", schema = "equipments")
public class EquipmentData {
    @Id
    private int id_equipment_data;
    private String statut;
    private String type_mode;
    private int value;
}
