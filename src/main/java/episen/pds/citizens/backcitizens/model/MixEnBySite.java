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

    public MixEnBySite(){}

    public MixEnBySite(int mix, String name_building){
        this.mix=mix;
        this.address=name_building;
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
    public void setAddress(String name_building){
        this.address=name_building;
    }
    public String toString(){
        return ""+address+" "+mix;
    }
}
