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

    @Column(name = "name_building")
    private String name_building;

    public MixEnBySite(){}

    public MixEnBySite(int mix, String address, String name_building){
        this.mix=mix;
        this.address=address;
        this.name_building=name_building;
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
    public String toString(){
        return ""+address+" "+mix + " "+name_building;
    }

}
