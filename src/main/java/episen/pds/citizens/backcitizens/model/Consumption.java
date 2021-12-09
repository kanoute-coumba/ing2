package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "consumption")
public class Consumption {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "value")
    public int value;

    @Column(name = "date_time")
    public Date date_time;

    @Column(name = "id_equipment")
    public int id_equipment;

}
