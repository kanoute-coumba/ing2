package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;

@Entity
@Table(name = "DWPBuildings")
public class DWPbyBuilding {

    @Id
    @Column(name = "id_building")
    private int id_building;

    @Column(name = "name_building")
    private String name_building;

    @Column(name = "nbreDWPs")
    private int nbreDWPs;

}
