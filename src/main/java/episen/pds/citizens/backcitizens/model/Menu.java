package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;




@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "menu_id")
    private int  menu_id;

    @Column(name = "starter")
    private String starter;

    @Column(name = "dish")
    private String dish;

    @Column(name = "dessert")
    private String dessert;


    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int id) {
        menu_id = id;
    }

    public String getStarter() {
        return starter;
    }

    public void setStarter(String Starter) {
        starter = Starter;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String Dish) {
       dish = Dish;
    }
    public String getDessert() {
        return dessert;
    }
    public void setDessert(String Dessert) {
        dessert = Dessert;
    }


    @Override
    public String toString() {
        return "Test{" +
                "Id=" + menu_id +
                ", lastname='" + starter + '\'' +
                ", firstname='" + dish + '\'' +
                ", firstname='" + dessert + '\'' +
                '}';
    }


}
