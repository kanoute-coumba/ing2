package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OccupationRate")
public class OccupationRateByBuilding {

    @Column(name="year")
    private int year;

    @Id
    @Column(name="name_building")
    private String name_building;

    @Column(name="rate")
    private int rate;

    @Override
    public String toString() {
        return "OccupationRateByBuilding{" +
                "year=" + year +
                ", name_building='" + name_building + '\'' +
                ", rate=" + rate +
                '}';
    }

    public OccupationRateByBuilding() {
    }

    public OccupationRateByBuilding(int year, String name_building, int rate) {
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
