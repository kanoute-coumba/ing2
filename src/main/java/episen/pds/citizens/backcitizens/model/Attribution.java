package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Attribution")
public class Attribution {
    @Id
    @Column(name = "id_attribution")
    private int Id;

    @Column(name = "date_time")
    private Date date_time;

    @Column(name = "value")
    private Double value;

    @Column(name = "id_building")
    private int id_building;

    public Attribution() {}

    public Attribution(int id, Date date_time, Double value, int id_building) {
        Id = id;
        this.date_time = date_time;
        this.value = value;
        this.id_building = id_building;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getId_building() {
        return id_building;
    }

    public void setId_building(int id_building) {
        this.id_building = id_building;
    }
}
