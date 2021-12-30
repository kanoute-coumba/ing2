package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
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

