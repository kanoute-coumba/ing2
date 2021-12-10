package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomsWithConsumption {
    @Id
    @Column(name = "id_room")
    private int id_room;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String date_time;

    @Override
    public String toString() {
        return "RoomsWithConsumption{" +
                "id_room=" + id_room +
                ", name='" + name + '\'' +
                ", date_time='" + date_time + '\'' +
                ", consumption=" + consumption +
                '}';
    }

    @Column(name = "value")
    private double consumption;

}
