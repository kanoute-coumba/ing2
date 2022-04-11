package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;



public class RSpace {


    @Column(name = "user_id")
    private int  user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "right_layer")
    private int right_layer;

    @Column(name = "type")
    private String type;

    @Column(name = "name_space")
    private String name_space;

    @Column(name = "type_space")
    private String type_space;

    @Column(name = "id_floor")
    private Integer id_floor;

    @Column(name = "reservation_id")
    private int  reservation_id;

    @Column(name = "start_time")
    private long start_time;

    @Column(name = "end_time")
    private long end_time;



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRight_layer() {
        return right_layer;
    }

    public void setRight_layer(int right_layer) {
        this.right_layer = right_layer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName_space() {
        return name_space;
    }

    public void setName_space(String name_space) {
        this.name_space = name_space;
    }

    public String getType_space() {
        return type_space;
    }

    public void setType_space(String type_space) {
        this.type_space = type_space;
    }

    public Integer getId_floor() {
        return id_floor;
    }

    public void setId_floor(Integer id_floor) {
        this.id_floor = id_floor;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;

    }

    @Override
    public String toString() {
        return "RSpace{" +

                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", right_layer=" + right_layer +
                ", type='" + type + '\'' +
                ", name_space='" + name_space + '\'' +
                ", type_space='" + type_space + '\'' +
                ", id_floor=" + id_floor +
                ", reservation_id=" + reservation_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }


}
