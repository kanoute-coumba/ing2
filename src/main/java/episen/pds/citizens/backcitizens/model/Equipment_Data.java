package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_data")
public class Equipment_Data {

    @Id
    @Column(name = "id_equipment_data")
    private int id_equipment_data;

    @Column(name = "statut")
    private String statut;

    @Column(name = "value")
    private double value;

    @Column(name = "type_mode")
    private String type_mode;

}
