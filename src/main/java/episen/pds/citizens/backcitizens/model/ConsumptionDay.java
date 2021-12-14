package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "consumption")
public class ConsumptionDay {
    @Id
    @Column(name = "id_consumption")
    private int id;

    @Column(name = "value")
    private Double value;

    @Column(name = "date_time")
    private Date date_time;

    @Column(name = "id_equipment")
    private int id_equipment;

    public ConsumptionDay() {
    }

    public ConsumptionDay(int id, Double value, Date date_time, int id_equipment) {
        this.id = id;
        this.value = value;
        this.date_time = date_time;
        this.id_equipment = id_equipment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public int getId_equipment() {
        return id_equipment;
    }

    public void setId_equipment(int id_equipment) {
        this.id_equipment = id_equipment;
    }
}
