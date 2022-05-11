package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MixEnBySite {
    @Column(name = "mix")
    private int mix;

    @Id
    @Column(name = "address")
    private String address;

    @Column(name = "type_building")
    private String name_building;

    @Column(name = "active_equip")
    private int active_equip;

    @Column(name = "number_equip")
    private int number_equip;

    //@Column(name = "capacity_used")
    //private int capacity_used;

    public MixEnBySite(){}

    public MixEnBySite(int mix, String address, String name_building, int active_equip, int number_equip){
        this.mix=mix;
        this.address=address;
        this.name_building=name_building;
        this.active_equip=active_equip;
        this.number_equip=number_equip;
    }

    public int getMix(){
        return mix;
    }
    public void setMix(int mix){
        this.mix=mix;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getName_building(){
        return name_building;
    }
    public void setName_building(String name_building){
        this.name_building=name_building;
    }
    public int getActive_equip() { return active_equip;}
    public void setActive_equip(int active_equip) { this.active_equip = active_equip;}
    public int getNumber_equip() { return number_equip;}
    public void setNumber_equip(int number_equip) { this.number_equip = number_equip;}

    @Override
    public String toString() {
        return "MixEnBySite{" +
                "mix=" + mix +
                ", address='" + address + '\'' +
                ", name_building='" + name_building + '\'' +
                ", active_equip=" + active_equip +
                ", number_equip=" + number_equip +
                '}';
    }
}
