package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TenantDetails")
public class TenantDetails {

    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "name_company")
    private String name_company;

    @Column(name = "type_space")
    private String type_space;

    @Column(name = "name_floor")
    private String name_floor;

    @Column(name = "name_building")
    private String name_building;

}
