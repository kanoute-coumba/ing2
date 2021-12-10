package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_space;
    private String name_space;
    private String type_space;
    private float length_space;
    private float width_space;
    private Integer id_floor;

    public Space() {
    }

    public Space(Integer id_space, String name_space, String type_space, float length_space, float width_space, Integer id_floor) {
        this.id_space = id_space;
        this.name_space = name_space;
        this.type_space = type_space;
        this.length_space = length_space;
        this.width_space = width_space;
        this.id_floor = id_floor;
    }
}
