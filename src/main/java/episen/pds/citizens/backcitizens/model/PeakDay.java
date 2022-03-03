package episen.pds.citizens.backcitizens.model;

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
    private Double consoday;

    @Column(name = "value")
    private Double value;

    @Column(name = "numberofpeak")
    private int numberofpeak;

    public PeakDay() {
    }

    public PeakDay(Date date, Double consoday, Double value, int numberofpeak) {
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

    public Double getConsoday() {
        return consoday;
    }

    public void setConsoday(Double consoday) {
        this.consoday = consoday;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getNumberofpeak() {
        return numberofpeak;
    }

    public void setNumberofpeak(int numberofpeak) {
        this.numberofpeak = numberofpeak;
    }
}

