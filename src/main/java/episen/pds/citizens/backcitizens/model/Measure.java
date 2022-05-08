package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "measure")
public class Measure {
    @Id
    @Column(name = "id_measure", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_measure;

    @Column
    private LocalDateTime timestamp;

    @Column
    private int value;

    @Column
    private int id_sensor;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public Integer getId_measure() {
        return id_measure;
    }

    public void setId_measure(Integer id_measure) {
        this.id_measure = id_measure;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "id_measure=" + id_measure +
                ", timestamp=" + timestamp +
                ", value=" + value +
                ", id_sensor=" + id_sensor +
                '}';
    }
}
