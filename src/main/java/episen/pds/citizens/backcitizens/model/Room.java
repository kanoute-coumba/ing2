package episen.pds.citizens.backcitizens.model;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    public int getIdRoom() {
        return idRoom;
    }

    @Id
    @Column(name="id_room")
    public int idRoom;

    public int getIdFloor() {
        return idFloor;
    }

    @Column(name="id_floor")
    public int idFloor;


}
