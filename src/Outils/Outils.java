package Outils;

import java.util.Random;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Outils {
    static public int lancerDes(int nbDés, int base, double multiplicateur) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1 + base;
        total *= multiplicateur;

        if (total < 0)
            total = 0;

        return total;
    }

    static public int lancerDes(int nbDés, int base) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1 + base;

        if (total < 0)
            total = 0;

        return total;
    }

    static public int maxAtteint(int stat, int max){
        if (stat > max) {
            return max;
        } else {
            return stat;
        }
    }
}
