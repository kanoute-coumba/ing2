package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentCounterByYear {

    @Column(name = "year")
    private int year;
    @Column(name = "name_building")
    private String name_building;
    @Id
    @Column(name = "counter")
    private int counter;

    public RentCounterByYear() {
    }

    public RentCounterByYear(int year, String name_building, int counter) {
        this.year = year;
        this.name_building = name_building;
        this.counter = counter;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
