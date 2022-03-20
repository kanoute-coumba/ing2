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
    private Double consoday;

    public ConsumptionDay() {

    }

    public ConsumptionDay(Date date, Double consoday) {
        this.date = date;
        this.consoday = consoday;
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
}