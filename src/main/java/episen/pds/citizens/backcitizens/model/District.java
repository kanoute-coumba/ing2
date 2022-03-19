package episen.pds.citizens.backcitizens.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class District {
    @Id
    @Column(name = "id_district")
    private int id;

    private String name;
}