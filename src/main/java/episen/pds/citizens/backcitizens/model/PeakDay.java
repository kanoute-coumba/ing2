package episen.pds.citizens.backcitizens.model;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name= "peakday")
public class PeakDay {

    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "consoday")
    private int consoday;

    @Column(name = "value")
    private int value;

    @Column(name = "numberofpeak")
    private int numberofpeak;

    public PeakDay() {
    }

    public PeakDay(Date date, int consoday, int value, int numberofpeak) {
        this.date = date;
        this.consoday = consoday;
        this.value = value;
        this.numberofpeak = numberofpeak;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getConsoday() {
        return consoday;
    }

    public void setConsoday(int consoday) {
        this.consoday = consoday;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberofpeak() {
        return numberofpeak;
    }

    public void setNumberofpeak(int numberofpeak) {
        this.numberofpeak = numberofpeak;
    }
}

