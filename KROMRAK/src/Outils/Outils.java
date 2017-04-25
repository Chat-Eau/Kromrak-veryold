package Outils;

import java.util.Random;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Outils {
    static public int lancerDes(int nbDés, int modificateur, double multiplicateur) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1 + modificateur;
        total *= multiplicateur;

        if (total < 0)
            total = 0;

        return total;
    }

    static public int lancerDes(int nbDés, int modificateur) {
        int total = 0;

        for (int x = 0; x < nbDés; x++)
            total += new Random().nextInt(4) + 1 + modificateur;

        if (total < 0)
            total = 0;

        return total;
    }
}
