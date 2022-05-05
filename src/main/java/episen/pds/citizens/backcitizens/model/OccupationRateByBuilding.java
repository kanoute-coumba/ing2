package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OccupationRate")
public class OccupationRateByBuilding {

    @Id
    @Column(name="year")
    private String year;

    @Column(name="name_building")
    private String name_building;

    @Column(name="rate")
    private String rate;

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

    public OccupationRateByBuilding(String year, String name_building, String rate) {
        this.year = year;
        this.name_building = name_building;
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName_building() {
        return name_building;
    }

    public void setName_building(String name_building) {
        this.name_building = name_building;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
