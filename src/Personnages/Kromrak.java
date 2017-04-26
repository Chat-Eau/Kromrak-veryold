package Personnages;

import Equipements.Arme;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Kromrak extends Personnage {
    private Kromrak() {
        this.arme = new Arme("Épée longue et dure", 1, 0);

        nom = "Kromrak";

        parade = false;

        //Attributs
        vieMax = 40;
        vie = vieMax;
        vitesse = 1;
        force = 0;
        dextérité = 1;//à faire
        endurance = 1;//à faire
        intelligence = 1;//à faire
        CA = 1;

        this.cible = null;
    }

    private static Kromrak kromrak = new Kromrak();

    public static Kromrak getInstance() {
        return kromrak;
    }
}
