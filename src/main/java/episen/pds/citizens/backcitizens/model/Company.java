package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "id_company")
    private int id_company;

    @Column(name = "name_company")
    private int name_company;

    public Company() {
    }

    public Company(int id_company, int name_company) {
        this.id_company = id_company;
        this.name_company = name_company;
    }

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public int getName_company() {
        return name_company;
    }

    public void setName_company(int name_company) {
        this.name_company = name_company;
    }
}
