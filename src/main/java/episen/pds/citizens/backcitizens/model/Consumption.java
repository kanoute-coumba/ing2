package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "consumption")
public class Consumption {
    @Id
    @Column(name = "id_consumption")
    private int id_consumption;

    @Column(name = "value")
    private double value;

    @Column(name = "date_time")
    private long date_time;

    @Column(name = "id_equipment")
    private int id_equipment;

    @Override
    public String toString() {
        return "Consumption{" +
                "Id=" + id_consumption +
                ", value=" + value +
                ", date_time='" + date_time  + id_equipment + '\'' +
                '}';
    }

    public int getId_consumption() {
        return id_consumption;
    }

    public void setId_consumption(int id_consumption) {
        this.id_consumption = id_consumption;
    }

    public double getValue() {
        return value;
    }

    public Consumption(int id_consumption, double value, long date_time, int id_equipment) {
        this.id_consumption = id_consumption;
        this.value = value;
        this.date_time = date_time;
        this.id_equipment = id_equipment;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getDate_time() {
        return date_time;
    }

    public void setDate_time(long date_time) {
        this.date_time = date_time;
    }

    public int getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }
}
