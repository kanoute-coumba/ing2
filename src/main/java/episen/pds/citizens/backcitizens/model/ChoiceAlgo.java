package episen.pds.citizens.backcitizens.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChoiceAlgo {
    @Id
    @Column(name = "id_choice_algo")
    private int id_choice_algo;
    @Column(name = "choice")
    private String choice;
    @Column(name = "pref1")
    private String pref1;
    @Column(name = "pref2")
    private String pref2;
    @Column(name = "pref3")
    private String pref3;
    @Column(name = "prop1")
    private float prop1;
    @Column(name = "prop2")
    private float prop2;
    @Column(name = "prop3")
    private float prop3;

    public ChoiceAlgo(){

    }

    public ChoiceAlgo(int id, String choice, String pref1, String pref2, String pref3, float prop1, float prop2, float prop3) {
        this.id_choice_algo = id;
        this.choice = choice;
        this.pref1 = pref1;
        this.pref2 = pref2;
        this.pref3 = pref3;
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
    }


    public int getIdChoiceAlgo() {
        return id_choice_algo;
    }

    public void setIdChoiceAlgo(int id) {
        this.id_choice_algo = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getPref1() {
        return pref1;
    }

    public void setPref1(String pref1) {
        this.pref1 = pref1;
    }

    public String getPref2() {
        return pref2;
    }

    public void setPref2(String pref2) {
        this.pref2 = pref2;
    }

    public String getPref3() {
        return pref3;
    }

    public void setPref3(String pref3) {
        this.pref3 = pref3;
    }

    public float getProp1() {
        return prop1;
    }

    public void setProp1(float prop1) {
        this.prop1 = prop1;
    }

    public float getProp2() {
        return prop2;
    }

    public void setProp2(float prop2) {
        this.prop2 = prop2;
    }

    public float getProp3() {
        return prop3;
    }

    public void setProp3(float prop3) {
        this.prop3 = prop3;
    }
}
