package episen.pds.citizens.backcitizens.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Attribution")
public class Attribution {
    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private Double value;

    public Attribution() {

    }
    public Attribution(Date date, Double value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
