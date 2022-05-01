package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Workplace")
public class Workplace {
    @Id
    @Column(name = "id_workplace")
    private int id_workplace;

    @Column(name = "id_space")
    private int id_space;

    @Column(name = "type_space")
    private String type_space;

    @Column(name = "id_floor")
    private int id_floor;

    @Column(name = "name_floor")
    private String name_floor;

    @Column(name = "id_building")
    private int id_building;

    @Column(name = "name_building")
    private String name_building;

    public Workplace() {
    }

    public Workplace(int id_workplace, int id_space, String type_space, int id_floor, String name_floor, int id_building, String name_building) {
        this.id_workplace = id_workplace;
        this.id_space = id_space;
        this.type_space = type_space;
        this.id_floor = id_floor;
        this.name_floor = name_floor;
        this.id_building = id_building;
        this.name_building = name_building;
    }
}
