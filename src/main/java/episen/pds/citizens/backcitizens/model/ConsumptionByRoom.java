package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumptionByRoom {
    @Id
    @Column(name = "id_room")
    private int id_room;

    @Column(name = "value")
    private double value;

    @Column(name = "date_time")
    private String date_time;

    @Override
    public String toString() {
        return "ConsumptionByRoom{" +
                "id_room=" + id_room +
                ", value=" + value +
                ", date_time='" + date_time + '\'' +
                '}';
    }
}
