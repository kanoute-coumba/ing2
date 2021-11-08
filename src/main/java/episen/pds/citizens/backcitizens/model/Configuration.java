package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Configuration")
public class Configuration {
    @javax.persistence.Id
    @Column(name = "id")
    private int Id;

    @Column(name = "value")
    private double luminosity;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "begin_time")
    private String begin_time;
}
