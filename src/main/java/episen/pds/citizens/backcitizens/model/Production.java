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
    private int value;

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
}
