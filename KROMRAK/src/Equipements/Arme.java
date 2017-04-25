package Equipements;

import Outils.Outils;
//BANJOURE
import static Outils.Outils.lancerDes;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Arme {
    private String nom;
    private int nbDés;
    private int modificateur;

    public Arme () {
        this.nbDés = 1;
        this.modificateur = 0;
        this.nom = "Epée courte et molle";
    }

    public Arme (String nom,int nbDés,int modificateur) {
        this.nbDés = nbDés;
        this.modificateur = modificateur;
        this.nom = nom;
    }

    public int getDegats() {
        return lancerDes(nbDés, modificateur);
    }
}

