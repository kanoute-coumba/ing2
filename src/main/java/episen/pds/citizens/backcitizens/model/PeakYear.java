package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
public class PeakYear {
    @Id
    @Column(name = "year")
    private int year;

    @Column(name = "numberofpeak")
    private int numberofpeak;

    public PeakYear() {
    }

    public PeakYear(int year, int numberofpeak) {
        this.year = year;
        this.numberofpeak = numberofpeak;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberofpeak() {
        return numberofpeak;
    }

    public void setNumberofpeak(int numberofpeak) {
        this.numberofpeak = numberofpeak;
    }
}
