package episen.pds.citizens.backcitizens.model.equipments;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "right_layer")
    private Integer right_layer;

    public User(Integer user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }

    public User() {

    }

}
