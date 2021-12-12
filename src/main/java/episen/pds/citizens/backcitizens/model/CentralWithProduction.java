package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CentralWithProduction {
    @Id
    @Column(name = "id_central")
    public int id_central;

    @Column(name = "type")
    public String type;

    @Column(name = "value")
    public String value;

    public int getId_central() {
        return id_central;
    }

    public void setId_central(int id_central) {
        this.id_central = id_central;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CentralWithProductionRepo{" +
                "id_central=" + id_central +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
