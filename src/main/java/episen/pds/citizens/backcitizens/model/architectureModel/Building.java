package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_building;
    private String address;
    private String name_building;
    private String type_building;

    public Building() { }

    public Building(Integer id_building, String address, String name_building, String type_building) {
        this.id_building = id_building;
        this.address = address;
        this.name_building = name_building;
        this.type_building = type_building;
    }
}

