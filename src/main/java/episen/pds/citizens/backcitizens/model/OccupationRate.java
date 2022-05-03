package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OccupationRate {

    @Id
    @Column(name="year")
    private int year;

    @Column(name="name_building")
    private String name_building;

    @Column(name="rate")
    private int rate;

    public OccupationRate() {
    }

    public OccupationRate(int year, String name_building, int rate) {
        this.year = year;
        this.name_building = name_building;
        this.rate = rate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName_building() {
        return name_building;
    }

    public void setName_building(String name_building) {
        this.name_building = name_building;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
