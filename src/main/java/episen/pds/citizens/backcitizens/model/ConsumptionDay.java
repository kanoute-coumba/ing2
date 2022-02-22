package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "consobyday")
public class ConsumptionDay {
    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "consoday")
    private int consoday;

    public ConsumptionDay() {

    }

    public ConsumptionDay(Date date, int consoday) {
        this.date = date;
        this.consoday = consoday;
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
}