package episen.pds.citizens.backcitizens.model;

public class MixEnCapacityBySite {

    private int mix;
    private int production;
    private String address;
    private String name_building;
    private int active_equip;
    private int number_equip;
private int capacity_used;

    public MixEnCapacityBySite(){}

    public MixEnCapacityBySite(int mix, int production, String address, String name_building, int active_equip, int number_equip, int capacity_used){
        this.mix=mix;
        this.production=production;
        this.address=address;
        this.name_building=name_building;
        this.active_equip=active_equip;
        this.number_equip=number_equip;
        this.capacity_used = capacity_used;
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
    public int getProduction() { return production;}
    public void setProduction(int production) { this.production = production;}
    public int getActive_equip() { return active_equip;}
    public void setActive_equip(int active_equip) { this.active_equip = active_equip;}
    public int getNumber_equip() { return number_equip;}
    public void setNumber_equip(int number_equip) { this.number_equip = number_equip;}
    public int getCapacity_used() { return capacity_used;}
    public void setCapacity_used(int capacity_used) { this.capacity_used = capacity_used;}

    public String toString(){
        return ""+address+" "+mix + " "+production+ " "+name_building+ " "+active_equip+ " "+number_equip+ " "+capacity_used;
    }
}
