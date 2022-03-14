package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "equipment")
public class DWP_Equipment {
    @Id
    @Column(name = "id_equipment")
    private int id_equipment;

    @Column(name = "type")
    private String type;

    @Column(name = "id_room")
    private int id_room;

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

    @Override
    public String toString() {
        return "Equipment{" +
                "id_equipment=" + id_equipment +
                ", type='" + type + '\'' +
                ", id_room=" + id_room +
                '}';
    }
}
