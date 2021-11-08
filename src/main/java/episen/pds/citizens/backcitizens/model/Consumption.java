package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consumption")
public class Consumption {
    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "value")
    private double value;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    public void setId(int id) {
        Id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return Id;
    }

    public double getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}
