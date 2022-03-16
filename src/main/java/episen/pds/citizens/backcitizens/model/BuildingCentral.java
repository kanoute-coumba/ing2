package episen.pds.citizens.backcitizens.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BuildingCentral {
    @Id
    @Column(name = "id_building")
    private Integer id;

    @Column(name = "name_building")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "type_building")
    private String type;

    @Column(name = "max_capacity")
    private Double maxCapacity;

    @Column(name = "capacity")
    private Double capacity;
}

