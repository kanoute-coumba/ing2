package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_floor;
    private String name_floor;
    private Integer id_building;
    private Integer id_design;

    public Floor() {
    }

    public Floor(Integer id_floor, String name_floor, Integer id_building, Integer id_design) {
        this.id_floor = id_floor;
        this.name_floor = name_floor;
        this.id_building = id_building;
        this.id_design = id_design;
    }
}
