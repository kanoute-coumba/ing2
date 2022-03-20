package episen.pds.citizens.backcitizens.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Central {
    @Id
    @Column(name = "id_central")
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "state")
    private String state;

    @Column(name = "id_building")
    private Integer idBuilding;
}
