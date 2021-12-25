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
@Table(schema = "equipments")
public class House {
    @Id
    private Integer id_house;
    private String address;
    private Integer id_owner;
}
