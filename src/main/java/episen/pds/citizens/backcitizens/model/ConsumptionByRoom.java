package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsumptionByRoom {
    @Id
    @Column(name = "id_room")
    private int id_room;

    @Column(name = "value")
    private double value;

    @Column(name = "date_time")
    private String date_time;

}
