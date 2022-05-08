package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RateXtraction {
    @Id
    @Column(name="year")
    private int year;

    @Column(name="name_building")
    private int name_building;

    @Column(name="nbredwps")
    private int nbredwps;

    @Column(name="counter")
    private int counter;

    public RateXtraction() {
    }

    public RateXtraction(int year, int name_building, int nbredwps, int counter) {
        this.year = year;
        this.name_building = name_building;
        this.nbredwps = nbredwps;
        this.counter = counter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getName_building() {
        return name_building;
    }

    public void setName_building(int name_building) {
        this.name_building = name_building;
    }

    public int getNbredwps() {
        return nbredwps;
    }

    public void setNbredwps(int nbredwps) {
        this.nbredwps = nbredwps;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
