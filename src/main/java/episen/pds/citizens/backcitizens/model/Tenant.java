package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tenant")
public class Tenant {

    @Id
    @Column(name = "id_tenant")
    private int id_tenant;

    @Column(name = "id_company")
    private int id_company;

    @Column(name = "id_space")
    private long id_space;

    @Column(name = "date")
    private Date date;

    public Tenant() {
    }

    public Tenant(int id_tenant, int id_company, long id_space, Date date) {
        this.id_tenant = id_tenant;
        this.id_company = id_company;
        this.id_space = id_space;
        this.date = date;
    }

    public int getId_tenant() {
        return id_tenant;
    }

    public void setId_tenant(int id_tenant) {
        this.id_tenant = id_tenant;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public long getId_space() {
        return id_space;
    }

    public void setId_space(long id_space) {
        this.id_space = id_space;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
