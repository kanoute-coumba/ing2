package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Production")
public class Production {
    @javax.persistence.Id
    @Column(name = "id_production")
    private int Id;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "value")
    private Double value;

    @Column(name = "id_central")
    private int id_central;

    @Override
    public String toString() {
        return "Production{" +
                "Id=" + Id +
                ", timestamp=" + timestamp +
                ", value=" + value +
                ", id_central=" + id_central +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getId_central() {
        return id_central;
    }

    public void setId_central(int id_central) {
        this.id_central = id_central;
    }
}
