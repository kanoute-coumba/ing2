package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
public class PeakMonth {
    @Id
    @Column(name = "month")
    private int month;

    @Column(name = "numberofpeak")
    private int numberofpeak;

    public PeakMonth() {
    }

    public PeakMonth(int month, int numberofpeak) {
        this.month = month;
        this.numberofpeak = numberofpeak;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getNumberofpeak() {
        return numberofpeak;
    }

    public void setNumberofpeak(int numberofpeak) {
        this.numberofpeak = numberofpeak;
    }
}
