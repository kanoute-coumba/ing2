package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Configuration {
    @Id
    private Integer id_configuration;
    private String date_configuration;
    private Integer id_floor;
    private Integer id_design;
    private Integer office_number;
    private Integer openSpace_number;
    private Integer individualSpace_number;
    private Integer meetingRoom_number;

    public Configuration() { }

    public Configuration(Integer id_configuration, String date_configuration, Integer id_floor, Integer id_design, Integer office_number, Integer openSpace_number, Integer individualSpace_number, Integer meetingRoom_number) {
        this.id_configuration = id_configuration;
        this.date_configuration = date_configuration;
        this.id_floor = id_floor;
        this.id_design = id_design;
        this.office_number = office_number;
        this.openSpace_number = openSpace_number;
        this.individualSpace_number = individualSpace_number;
        this.meetingRoom_number = meetingRoom_number;
    }
}

