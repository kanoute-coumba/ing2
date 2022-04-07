package episen.pds.citizens.backcitizens.model;

import javax.persistence.*;

@Entity
public class HistoricalProduction {
    //private Long id;

    @Column(name = "energie")
    private String energie;
    @Id
    @Column(name = "mois")
    private String mois;
    @Column(name = "jour")
    private int jour;
    @Column(name = "valeur")
    private double valeur;


    public HistoricalProduction(String energie, String mois, int jour, double valeur) {
        //this.id = id;
        this.energie = energie;
        this.mois = mois;
        this.jour = jour;
        this.valeur = valeur;
    }
    public HistoricalProduction(){

    }
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 */

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "HistoricalProduction{" +
                "energie='" + energie + '\'' +
                ", mois='" + mois + '\'' +
                ", jour=" + jour +
                ", valeur=" + valeur +
                '}';
    }
}
