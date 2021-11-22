package episen.pds.citizens.backcitizens.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.IOException;
import java.util.Properties;


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
