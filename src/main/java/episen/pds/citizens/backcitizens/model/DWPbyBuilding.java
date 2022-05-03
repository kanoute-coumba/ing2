package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;

@Entity
public class DWPbyBuilding {

    @Id
    @Column(name = "id_building")
    private int id_building;

    @Column(name = "name_building")
    private String name_building;

    @Column(name = "nbreDWPs")
    private int nbreDWPs;

    public DWPbyBuilding() {
    }

    public DWPbyBuilding(int id_building, String name_building, int nbreDWPs) {
        this.id_building = id_building;
        this.name_building = name_building;
        this.nbreDWPs = nbreDWPs;
    }

    public int getId_building() {
        return id_building;
    }

    public void setId_building(int id_building) {
        this.id_building = id_building;
    }

    public String getName_building() {
        return name_building;
    }

    public void setName_building(String name_building) {
        this.name_building = name_building;
    }

    public int getNbreDWPs() {
        return nbreDWPs;
    }

    public void setNbreDWPs(int nbreDWPs) {
        this.nbreDWPs = nbreDWPs;
    }
}
