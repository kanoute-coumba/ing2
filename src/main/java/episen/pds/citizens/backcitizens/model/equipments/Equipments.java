package episen.pds.citizens.backcitizens.model.equipments;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "equipment", schema = "equipments")
public class Equipments {

    @Id
    private int id_equipment;
    private String type;
    private int id_room;
    private int id_equipment_data;
    private boolean prod;
}
