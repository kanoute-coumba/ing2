package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_space;
    private String name_space;
    private String type_space;
    private Integer id_floor;
    private Integer prox_asc;
    private Integer prox_cor1;
    private Integer prox_cor2;

    public Space() {
    }

    public Space(Integer id_space, String name_space, String type_space, Integer id_floor, Integer prox_asc, Integer prox_cor1, Integer prox_cor2) {
        this.id_space = id_space;
        this.name_space = name_space;
        this.type_space = type_space;
        this.id_floor = id_floor;
        this.prox_asc = prox_asc;
        this.prox_cor1 = prox_cor1;
        this.prox_cor2 = prox_cor2;
    }
}
