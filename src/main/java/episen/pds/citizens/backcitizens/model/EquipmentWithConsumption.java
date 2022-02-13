package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class EquipmentWithConsumption {
    @Id
    @Column(name = "id_equipment")
    public int id_equipment;

    @Column(name = "id_room")
    public int id_room;

    @Column(name = "type")
    public String type;

    @Column(name = "value")
    public String value;

    @Column(name ="date_time")
    LocalDateTime date_time;

    public int getIdRoom() {
        return id_room;
    }

    public int getId() {
        return id_equipment;
    }
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EquipmentWithConsumption{" +
                "id_equipment=" + id_equipment +
                ", id_room=" + id_room +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
