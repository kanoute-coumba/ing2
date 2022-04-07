package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Configuration {
    @Id
    private Integer id_configuration;
    private String  date_configuration;
    private Integer id_floor;
    private Integer id_design;
    private Integer office_number;
    private Integer openspace_number;
    private Integer meetingroom_number;
    private Integer individualroom_number;

    public Configuration() {
    }

    public Configuration(Integer id_configuration, String date_configuration, Integer id_floor, Integer id_design, Integer office_number, Integer openspace_number, Integer meetingroom_number, Integer individualroom_number) {
        this.id_configuration = id_configuration;
        this.date_configuration = date_configuration;
        this.id_floor = id_floor;
        this.id_design = id_design;
        this.office_number = office_number;
        this.openspace_number = openspace_number;
        this.meetingroom_number = meetingroom_number;
        this.individualroom_number = individualroom_number;
    }
}

