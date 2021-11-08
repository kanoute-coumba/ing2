package episen.pds.citizens.backcitizens.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;


@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "type")
    public String type;

    public int getIdRoom() {
        return idRoom;
    }

    @Column(name = "id_room")
    public int idRoom;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
