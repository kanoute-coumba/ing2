package episen.pds.citizens.backcitizens.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "id_room")
    private int id_room;

    @Column(name = "name")
    private String name;

    @Column(name = "id_floor")
    private int id_floor;

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_floor() {
        return id_floor;
    }

    public void setId_floor(int id_floor) {
        this.id_floor = id_floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id_room=" + id_room +
                ", name='" + name + '\'' +
                ", id_floor=" + id_floor +
                '}';
    }
}
