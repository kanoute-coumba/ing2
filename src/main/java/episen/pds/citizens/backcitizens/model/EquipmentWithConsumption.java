package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EquipmentWithConsumption {
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

    @Column(name = "value")
    public String value;

    public String getValue() {
        return value;
    }
}
