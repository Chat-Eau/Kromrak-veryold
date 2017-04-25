package Evennements;

import Equipements.Arme;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat {
    private int tour = 1;
    private Personnage[] personnages;
    private Kromrak kromrak;

    public Combat() {
        this.kromrak = Kromrak.getInstance();
        this.personnages = new Personnage[]{kromrak, new Ennemi("goblin 1"), new Ennemi("goblin 2")};
    }

    public void combat()
    {
        ordreTour();

        while (this.verifierEtat() == 0 ) {
            for (Personnage personnage : this.personnages) {
                if (this.verifierEtat() != 0) break;
                else if (personnage.estVivant() && personnage.avancerVitesse() == true) {
                    System.out.println(System.lineSeparator() + "Tour " + this.tour);
                    if (personnage == this.kromrak) tourKromrak();
                    else if (personnage.estVivant())tourEnnemi(personnage);
                    this.tour++;
                }
            }
        }

        if (this.verifierEtat() < 1) {
            System.out.println("Va chier Kromrak.");
        }
        else {
            System.out.println("Je t'aime, Kromrak!");
        }
    }



    protected void tourKromrak(){
        boolean valide = true;
        Scanner scanner;
        String choix;

        System.out.println(System.lineSeparator() + "Votre tour : ");
        System.out.println("1. Attaquer");

        do{
            valide = true;
            scanner = new Scanner(System.in);
            choix = scanner.nextLine();
            switch (choix){
                case "1":
                    cible();
                    if (this.kromrak.verrifierReaction() > 0) reactionEnnemi(this.kromrak.getCible());
                    this.kromrak.attaquer();
                    if (!(this.kromrak.getCible().estVivant())) ennemiMort(this.kromrak.getCible());
                    break;
                default:
                    valide = false;
                    break;
            }
        } while (!valide);
    }

    protected void reactionEnnemi(Personnage ennemi) {
        if (new Random().nextInt(3) == 0) {
            System.out.println(System.lineSeparator() + ennemi.getNom() + " bloque l'attaque!" + System.lineSeparator());
            ennemi.activerParade();
        } else {
            System.out.println(System.lineSeparator() + ennemi.getNom() + " contre-attaque!" + System.lineSeparator());
            ennemi.attaquer();
        }
    }

    protected void tourEnnemi(Personnage ennemi){
        System.out.println(System.lineSeparator() + ennemi.getNom());
        ennemi.attaquer();
    }

    protected void cible(){
        boolean valide = true;
        int noEnnemi = 0;
        Scanner scanner;
        String choix;

        System.out.println("Choisisser votre cible : ");

        for (int i = 1; i < this.personnages.length; i++){
            if(this.personnages[i].estVivant())
                System.out.println(i + ". " + this.personnages[i].getNom());
            i++;
        }

        do{
            //chat
            valide = true;
            scanner = new Scanner(System.in);
            choix = scanner.nextLine();
            noEnnemi = Integer.parseInt(choix) - 1;
            if ( !this.personnages[noEnnemi].estVivant() || noEnnemi < 0 || noEnnemi >= this.personnages.length - 1) {
                valide = false;
            }

        } while (!valide);

        this.kromrak.setCible(this.personnages[noEnnemi]);
    }

    protected int verifierEtat(){
        int etatCombat = 1;
        for (Personnage personnage:this.personnages)
            if (personnage.estVivant()) etatCombat = 0;
        if (!this.kromrak.estVivant()) etatCombat = -1;

        return etatCombat;
    }

    protected void ennemiMort(Personnage mort) {
        System.out.println(this.kromrak.getCible().getNom() + " est mort." + System.lineSeparator());
    }

    protected void ordreTour() {
        Personnage tampon;
        for (int i = this.personnages.length; i > 1; i--) {
            tampon = this.personnages[1];
            for (int j = 2; j < i; j++) {
                if (tampon.getVitesse() > this.personnages[j].getVitesse()) {
                    tampon = this.personnages[j];
                } else {
                    this.personnages[j - 1] = this.personnages[j];
                    this.personnages[j] = tampon;
                }
            }
        }
    }
}
