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

    public TenantDetails() {
    }

    public TenantDetails(Date date, String name_company, String type_space, String name_floor, String name_building) {
        this.date = date;
        this.name_company = name_company;
        this.type_space = type_space;
        this.name_floor = name_floor;
        this.name_building = name_building;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getType_space() {
        return type_space;
    }

    public void setType_space(String type_space) {
        this.type_space = type_space;
    }

    public String getName_floor() {
        return name_floor;
    }

    public void setName_floor(String name_floor) {
        this.name_floor = name_floor;
    }

    public String getName_building() {
        return name_building;
    }

    public void setName_building(String name_building) {
        this.name_building = name_building;
    }
}
