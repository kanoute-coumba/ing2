package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consumption")
public class Consumption {
    @javax.persistence.Id
    @Column(name = "id")
    private int Id;

    @Column(name = "value")
    private double value;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

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
