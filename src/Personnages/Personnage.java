package Personnages;


import Equipements.Arme;
import Outils.Outils;

import java.util.Random;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Personnage {
    protected Arme arme;
    protected String nom;
    //TODO: Cible? Pourquoi personnage a besoin d'un personnage cible?
    //TODO: La cible devrait etre le paramètre d'une fonction attaquer, pas une variable.
    protected Personnage cible;

    protected boolean parade = false;

    private int barreVitesse = 0;

    //Attributs
    //TODO: Une classe pour chaque attribut?
    //TODO: Pour séparer les get/set, les gérer individuellement pour les caps...
    protected int vieMax;
    protected int vie;
    protected int vitesse = 0;
    protected int force = 0;
    protected int dextérité = 0;//à faire
    protected int endurance = 0;//à faire
    protected int intelligence = 0;//à faire
    protected int CA = 1;

    static public final int STEP_TOUR = 3;
    static public final int STEP_REACTION = 100;


    protected Personnage() {}

    public void recevoirDegats (int nbDegats)
    {
        int degats = (this.parade == true)?nbDegats-1-this.CA:nbDegats;
        degats = (degats > 0)?degats:1;
        this.parade = false;

        System.out.println(this.nom + " a reçu: " + degats + " dégats.");

        this.vie -= degats;

        Outils.maxAtteint(vie, vieMax);
    }

    public int attaquer()
    {
        int degats = this.arme.getDegats();

        this.cible.recevoirDegats(degats + this.force - this.cible.CA);

        return degats;
    }

    public void gagnerVie (int nbVie)
    {
        this.vie += nbVie;
        if (this.vie > vieMax)
        {
            this.vie = vieMax;
        }
    }

    public void setArme (Arme arme)
    {
        this.arme = arme;
    }

    public void afficherEtat () {
        System.out.println("vie:" + this.vie + "/" + this.vieMax);

        //this.arme->afficher();
    }

    public boolean avancerVitesse() {
        this.barreVitesse += STEP_TOUR + vitesse;

        if (this.barreVitesse >= 100) {
            this.barreVitesse = 0;
            return true;
        }
        else return false;
    }

    public int verrifierReaction() {
        return new Random().nextInt((this.cible.getDextérité() + 1) * STEP_REACTION + 1)
                - new Random().nextInt((this.getDextérité() + 1) * STEP_REACTION + 1);
    }

    public boolean estVivant() { return vie > 0; }

    public Personnage getCible() { return cible; }

    public String getNom() { return this.nom; }

    public Arme getArme() {
        return arme;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getDextérité() {
        return dextérité;
    }

    public int getForce() {
        return force;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVie() {
        return vie;
    }

    public int getVieMax() {
        return vieMax;
    }

    public void activerParade() { parade = true; }

    public void setCible(Personnage cible) {this.cible = cible; }

}