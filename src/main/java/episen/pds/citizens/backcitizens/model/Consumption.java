package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Consumption")
public class Consumption {
    @javax.persistence.Id
    @Column(name = "id_consumption")
    private int Id;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "value")
    private int value;

    @Column(name = "id_equipment")
    private int id_equipment;

    @Override
    public String toString() {
        return "Consumption{" +
                "Id=" + Id +
                ", timestamp=" + timestamp +
                ", value=" + value +
                ", id_equipment=" + id_equipment +
                '}';
    }
}