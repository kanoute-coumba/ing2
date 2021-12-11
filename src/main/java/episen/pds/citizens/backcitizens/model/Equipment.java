package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column(name = "id_equipment")
    private int id_equipment;

    @Column(name = "type")
    private String type;

    @Column(name = "id_room")
    private int id_room;

    @Column(name = "statut")
    private String statut;

    @Column(name = "value")
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id_equipment=" + id_equipment +
                ", type='" + type + '\'' +
                ", id_room=" + id_room +
                ", statut='" + statut + '\'' +
                ", value=" + value +
                '}';
    }
}
