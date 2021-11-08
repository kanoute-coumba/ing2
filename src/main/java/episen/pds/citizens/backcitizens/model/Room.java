package episen.pds.citizens.backcitizens.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "edge")
    private boolean edge;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "begin_time")
    private String begin_time;

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
}
