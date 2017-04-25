package Personnages;

import Equipements.Arme;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Kromrak extends Personnage {
    private Kromrak() {
        this.nom = "Kromrak";

        this.vieMax = 40;
        this.vie = vieMax;

        this.force = 1;
        this.vitesse = 2;

        this.arme = new Arme("Épée longue et dure", 1, 0);
        this.cible = null;


    }

    private static Kromrak kromrak = new Kromrak();

    public static Kromrak getInstance() {
        return kromrak;
    }
}
