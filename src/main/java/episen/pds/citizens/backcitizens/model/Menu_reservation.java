package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;


@Entity
@Table(name = "menu_reservation")
public class Menu_reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int  reservation_id;

    @Column(name = "name")
    private String name;

    @Column(name = "menu_number")
    private int menu_number;

    @Column(name = "time_slot")
    private String time_slot;

    @Column(name = "note")
    private String note;


    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int id) {
        reservation_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public int getMenu_number() {
        return menu_number;
    }

    public void setMenu_number(int menu_number) {
        this.menu_number = menu_number;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "Test{" +
                "Id=" + reservation_id +
                ", name='" + name + '\'' +
                ", menu_number='" + menu_number + '\'' +
                ", note='" + note + '\'' +
                '}';
    }





}
