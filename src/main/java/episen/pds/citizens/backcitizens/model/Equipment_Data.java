package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_data")
public class Equipment_Data {
    @Id
    @Column(name = "id_equipment_data", nullable = false)
    private Integer id_equipment_data;

    @Column(name = "statut")
    private String statut;

    @Column(name = "value")
    private double value;

    @Column(name = "type_mode")
    private String type_mode;

    public Integer getId_equipment_data() {
        return id_equipment_data;
    }

    public void setId_equipment_data(Integer id_equipment_data) {
        this.id_equipment_data = id_equipment_data;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType_mode() {
        return type_mode;
    }

    public void setType_mode(String type_mode) {
        this.type_mode = type_mode;
    }

    @Override
    public String toString() {
        return "Equipment_Data{" +
                "id_equipment_data=" + id_equipment_data +
                ", statut='" + statut + '\'' +
                ", value=" + value +
                ", type_mode='" + type_mode + '\'' +
                '}';
    }
}
