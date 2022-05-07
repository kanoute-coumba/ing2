package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OccupationRate {

    @Id
    @Column(name="year")
    private int year;

    @Column(name="rate")
    private float rate;

    public OccupationRate() {
    }

    public OccupationRate(int year, float rate) {
        this.year = year;
        this.rate = rate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
