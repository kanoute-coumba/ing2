package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Production {
    @Id
    @Column(name = "id_production")
    private int id;

    @Column(name = "date_time")
    private Timestamp timestamp;

    @Column(name = "value")
    public double value;

    @Column(name = "id_central")
    private int idCentral;

    public Production() {
    }

    public Production(int id, Timestamp timestamp, double value, int idCentral) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.idCentral = idCentral;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public int getIdCentral() {
        return idCentral;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", value=" + value +
                ", idCentral=" + idCentral +
                '}';
    }
}
