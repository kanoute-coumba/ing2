package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consumption")
public class Consumption {
    @Id
    @Column(name = "id")
    private int Id;

    @Column(name = "value")
    private double value;

    @Column(name = "date_time")
    private String date_time;

}
