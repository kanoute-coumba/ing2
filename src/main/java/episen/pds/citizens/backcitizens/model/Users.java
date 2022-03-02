package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int  user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "right_layer")
    private int right_layer;

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public int getRight_layer() {
        return right_layer;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRight_layer(int right_layer) {
        this.right_layer = right_layer;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", right_layer=" + right_layer +
                '}';
    }
}


