package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MixEn {

    @Column(name = "mix")
    private int mix;

    @Id
    @Column(name = "address")
    private String address;

    public int getMix(){
        return mix;
    }
    public void setMix(int mix){
        this.mix=mix;
    }
    public String getAdress(){
        return address;
    }
    public void setAdress(String address){
        this.address=address;
    }
    public String toString(){
        return ""+address+" "+mix;
    }
}
