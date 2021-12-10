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
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_floor")
    private int id_floor;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", id_floor=" + id_floor +
                '}';
    }
}
