package Personnages;

import Equipements.Arme;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Ennemi extends Personnage {

    public Ennemi(String nom) {
        this.nom = nom;
        this.arme = new Arme();
        this.cible = Kromrak.getInstance();

        this.vieMax = 5;
        this.vitesse = 3;
        this.dextérité = 3;

        this.vie = vieMax;
    }

}
