package episen.pds.citizens.backcitizens.model;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ConsumptionByBuilding {
    @Id
    @Column(name = "id_building")
    private int id_building;

    @Column(name = "value")
    private double value;

    @Column(name = "date_time")
    private String date_time;
}
