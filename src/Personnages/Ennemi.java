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

        this.vieMax = Outils.lancerDes(1, 2);
        this.vitesse = Outils.lancerDes(1,-1);
        this.dextérité = Outils.lancerDes(1, -1);

        this.vie = vieMax;
    }

}
