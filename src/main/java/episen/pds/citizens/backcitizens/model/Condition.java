package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "conditions")
public class Condition {
    @Id
    @Column(name = "id_room")
    private int id_room;

    @Column(name = "luminosity")
    private double luminosity;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "begin_time")
    private String begin_time;

    @Column(name = "end_time")
    private String end_time;

    public int getId() {
        return id_room;
    }

    public void setId(int id) {
        id_room = id;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id_room=" + id_room +
                ", luminosity=" + luminosity +
                ", temperature=" + temperature +
                ", begin_time='" + begin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}
