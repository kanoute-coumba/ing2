package episen.pds.citizens.backcitizens.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "floor")
public class Floor {
    public int getIdFloor() {
        return idFloor;
    }

    public void setIdFloor(int idFloor) {
        this.idFloor = idFloor;
    }

    @Id
    @Column(name="id_floor")
    public int idFloor;

    public int getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(int idBuilding) {
        this.idBuilding = idBuilding;
    }

    @Column(name="id_building")
    public int idBuilding;

}
