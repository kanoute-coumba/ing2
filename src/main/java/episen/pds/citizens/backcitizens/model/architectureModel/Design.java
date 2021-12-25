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
    private float lengthOffice_design;
    private float widthOffice_design;
    private float lengthOpenSpace_design;
    private float widthOpenSpace_design;
    private float lengthIndividRoom_design;
    private float widthIndividRoom_design;
    private float lengthMeetRoom_design;
    private float widthMeetRoom_design;

    public Design() {
    }

    public Design(Integer id_design, String name_design, float lengthOffice_design, float widthOffice_design, float lengthOpenSpace_design, float widthOpenSpace_design, float lengthIndividRoom_design, float widthIndividRoom_design, float lengthMeetRoom_design, float widthMeetRoom_design) {
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