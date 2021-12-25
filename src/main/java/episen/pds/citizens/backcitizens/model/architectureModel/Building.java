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
    private Integer id_owner;
}

