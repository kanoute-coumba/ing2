package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumptionByBuilding {
    @Id
    @Column(name = "id_building")
    private int id_building;

    @Column(name = "value")
    private double value;

    @Column(name = "date_time")
    private String date_time;

    @Override
    public String toString() {
        return "ConsumptionByBuilding{" +
                "id_building=" + id_building +
                ", value=" + value +
                ", date_time='" + date_time + '\'' +
                '}';
    }
}
