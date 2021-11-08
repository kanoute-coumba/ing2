package episen.pds.citizens.backcitizens.model;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name= "consumption")
public class Consumption {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "value")
    public String value;

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
