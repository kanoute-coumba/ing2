package episen.pds.citizens.backcitizens.model.equipments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "equipments", name = "floor")
public class FloorHouse {
    @Id
    private Integer id_floor;
    private String name_floor;
    private Integer id_house;
}
