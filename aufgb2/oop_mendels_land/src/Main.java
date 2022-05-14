import mendels_land.Butterfly;
import mendels_land.ChildPopulation;
import mendels_land.MendelLand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] patterns = {"uniform", "black points", "black stripes"};
        String[] colors = {"red", "yellow", "green", "blue"};
        String[] wings = {"straight", "curved"};
        int numberOfParents = 10;

        // TODO
        // BASES CASES for MENDELLAND to check if attributes are empty
        MendelLand mendel = new MendelLand(patterns, colors, wings, 5);
        mendel. mendelMain();
    }


}