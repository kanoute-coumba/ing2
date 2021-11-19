package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipement")
public class Equipment {

    @Id
    @Column(name = "id_equip")
    private int id_equip;

    @Column(name = "equip_name")
    private String equip_name;

    @Column(name = "type_equip")
    private String type_equip;

    @Column(name = "locations")
    private String locations;

    public int getId_equip() {
        return id_equip;
    }

    public void setId_equip(int id_equip) {
        this.id_equip = id_equip;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public String getType_equip() {
        return type_equip;
    }

    public void setType_equip(String type_equip) {
        this.type_equip = type_equip;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id_equip=" + id_equip +
                ", equip_name='" + equip_name + '\'' +
                ", type_equip='" + type_equip + '\'' +
                ", locations='" + locations + '\'' +
                '}';
    }
}
