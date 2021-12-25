package episen.pds.citizens.backcitizens.model.architectureModel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_design;
    private String name_design;
    private Float lengthOffice_design;
    private Float widthOffice_design;
    private Float lengthOpenSpace_design;
    private Float widthOpenSpace_design;
    private Float lengthIndividRoom_design;
    private Float widthIndividRoom_design;
    private Float lengthMeetRoom_design;
    private Float widthMeetRoom_design;

    public Design() {
    }

    public Design(Integer id_design, String name_design, Float lengthOffice_design, Float widthOffice_design, Float lengthOpenSpace_design, Float widthOpenSpace_design, Float lengthIndividRoom_design, Float widthIndividRoom_design, Float lengthMeetRoom_design, Float widthMeetRoom_design) {
        this.id_design = id_design;
        this.name_design = name_design;
        this.lengthOffice_design = lengthOffice_design;
        this.widthOffice_design = widthOffice_design;
        this.lengthOpenSpace_design = lengthOpenSpace_design;
        this.widthOpenSpace_design = widthOpenSpace_design;
        this.lengthIndividRoom_design = lengthIndividRoom_design;
        this.widthIndividRoom_design = widthIndividRoom_design;
        this.lengthMeetRoom_design = lengthMeetRoom_design;
        this.widthMeetRoom_design = widthMeetRoom_design;
    }
}