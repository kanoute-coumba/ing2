package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "conditions")
public class Conditions {

    @Column(name = "luminosity")
    private int luminosity;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "begin_time")
    private LocalTime begin_time;

    @Column(name = "end_time")
    private LocalTime end_time;

    @Id
    @Column(name = "id_room")
    private int id_room;

    public int getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public LocalTime getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(LocalDateTime begin_time) {
        this.begin_time = begin_time;
    }

    public LocalTime getEnd_time(LocalDateTime of) {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "luminosity=" + luminosity +
                ", temperature=" + temperature +
                ", begin_time=" + begin_time +
                ", end_time=" + end_time +
                '}';
    }
}
