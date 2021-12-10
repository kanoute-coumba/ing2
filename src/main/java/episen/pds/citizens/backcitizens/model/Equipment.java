package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Equipment")
public class Equipment {
    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private double value;
    private String room;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "Id=" + Id +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
