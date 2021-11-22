package episen.pds.citizens.backcitizens.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @Column(name = "id_building")
    private int id;

    @Column(name = "name_building")
    private String name;

    @Column(name = "address")
    private String address;

    //private double consumption;
    //private double production;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}
