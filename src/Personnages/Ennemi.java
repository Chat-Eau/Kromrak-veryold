package Personnages;

import Equipements.Arme;
import Outils.Outils;
/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Ennemi extends Personnage {


    public Ennemi(String nom) {
        this.nom = nom;
        this.arme = new Arme();
        //TODO: Pas besoin de cible, il faut seulement separer les IA.
        //TODO: Faire deux fonctions jouerTour(). Celle des ennemis attaque toujours le joueur.
        this.cible = Kromrak.getInstance();

        vieMax = Outils.lancerDes(1, 2);
        vie = vieMax;
        vitesse = Outils.lancerDes(1, -1);
        force = Outils.lancerDes(1, -2);
        dextérité = Outils.lancerDes(1, -2);
        endurance = Outils.lancerDes(1, -2);
        intelligence = 0;
        CA = Outils.lancerDes(1, -2);
    }

//    public void jouerTour(){
//        System.out.println("Au tour de : " + this.getNom());
//        this.attaquer();
//    }
}
