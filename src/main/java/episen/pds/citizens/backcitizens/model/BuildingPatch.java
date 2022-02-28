package episen.pds.citizens.backcitizens.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuildingPatch {
    @Id
    @Column(name = "id_building")
    private int id;

    @Column(name = "name_building")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "type_building")
    private String type;

    @Column(name = "consumption")
    private Double consumption;

    @Column(name = "production")
    private Double production;

    @Column(name = "district")
    private Integer district;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getType() {
        return this.type;
    }

    public Double getConsumption() {
        return this.consumption;
    }

    public Double getProduction() {
        return this.production;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public void setProduction(Double production) {
        this.production = production;
    }

    @Override
    public String toString(){
        return "[" + this.id + ", "
                + this.name + ", "
                + this.address + ", "
                + this.type + ", "
                + this.consumption + ", "
                + this.production + "]";
    }
}
