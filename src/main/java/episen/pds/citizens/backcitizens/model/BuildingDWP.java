package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuildingDWP {

    @Id
    @Column(name = "id_building")
    private int id_building;

    @Column(name = "name_building")
    private String name_building;

}
