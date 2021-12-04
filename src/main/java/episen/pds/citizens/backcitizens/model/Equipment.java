package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipement")
public class Equipment {

    @Id
    @Column(name = "id_equipment")
    private int id_equipment;

    @Column(name = "id_room")
    private int id_room;

    @Column(name = "type")
    private String type;

    @Column(name = "statut")
    private String statut;

    @Column(name = "type_mode")
    private String type_mode;

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

    public String getType_mode() {
        return type_mode;
    }

    public void setType_mode(String type_mode) {
        this.type_mode = type_mode;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id_equipment=" + id_equipment +
                ", id_room=" + id_room +
                ", type='" + type + '\'' +
                ", statut='" + statut + '\'' +
                ", type_mode='" + type_mode + '\'' +
                '}';
    }
}
