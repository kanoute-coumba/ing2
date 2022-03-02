package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;

@Entity
public class EquipmentAndData {
    @Id
    @Column(name = "id_equipment")
    int id_equipment;
    @Column(name="type_mode")
    String type_mode;
    @Column(name = "id_room")
    int id_room;
    @Column(name="type")
    String type;
    @Column(name="value")
    int value;
    @Column(name="statut")
    String statut;

    public int getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
        return "EquipmentAndData{" +
                "id_equipment=" + id_equipment +
                ", id_room=" + id_room +
                ", type='" + type + '\'' +
                ", statut='" + statut + '\'' +
                ", value=" + value +
                ", type_mode='" + type_mode + '\'' +
                '}';
    }
}
