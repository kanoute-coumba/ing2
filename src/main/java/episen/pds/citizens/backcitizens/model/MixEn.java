package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MixEn {

    @Column(name = "mix")
    private int mix;

    @Id
    @Column(name = "type_building")
    private String name_building;

    public MixEn(){}

    public MixEn(int mix, String name_building){
        this.mix=mix;
        this.name_building=name_building;
    }

    public int getMix(){
        return mix;
    }
    public void setMix(int mix){
        this.mix=mix;
    }
    public String getNameBuilding(){
        return name_building;
    }
    public void setNameBuilding(String name_building){
        this.name_building=name_building;
    }
    public String toString(){
        return ""+name_building+" "+mix;
    }
}
