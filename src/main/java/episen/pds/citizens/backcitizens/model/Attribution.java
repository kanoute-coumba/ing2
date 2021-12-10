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
    private int value;

    @Column(name = "id_building")
    private int id_building;
}
