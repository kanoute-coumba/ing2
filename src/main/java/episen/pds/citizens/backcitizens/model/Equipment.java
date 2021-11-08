package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "Equipment")
public class Equipment {
    @javax.persistence.Id
    @Column(name = "id")
    private int Id;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private double value;

}
