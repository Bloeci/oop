import mendels_land.Butterfly;
import mendels_land.MendelLand;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // ArrayList<Butterfly[]> parents = generateParents();

        int numberOfParents = 6;
        ArrayList<Butterfly[]> pairsOfParents = generateRandomParents(numberOfParents);

        MendelLand mendel = new MendelLand(pairsOfParents);
        mendel.mendelLoop();
    }

    /**
     * Generate one pair of parents.
     * @return parents
     */
    public static ArrayList<Butterfly[]> generateParents() {
        Butterfly mother = new Butterfly("uniform","green", "curved");

        Butterfly father = new Butterfly("black points", "yellow", "straight");

        Butterfly[] parent = {mother, father};
        ArrayList<Butterfly[]> parents = new ArrayList<>();
        parents.add(parent);
        return parents;
    }

    /**
     * Generate n random parents pairs.
     * @param numParents Number of total parent pairs.
     * @return parents  List of parents (pair of mother and father).
     */
    public static ArrayList<Butterfly[]> generateRandomParents(int numParents){
        String[] patterns = {"uniform", "black points", "black stripes"};
        String[] colors = {"red", "yellow", "green", "blue"};
        String[] shapes = {"straight", "curved"};

        ArrayList<Butterfly[]> parents = new ArrayList<>();
        Random rand = new Random();
        // generate random parents
        while (numParents > 0){
            Butterfly[] tmp = new Butterfly[2];
            for (int i = 0; i < 2; i++){
                String randomPattern = patterns[rand.nextInt(patterns.length)];
                String randomColor = colors[rand.nextInt(colors.length)];
                String randomWings = shapes[rand.nextInt(shapes.length)];

                Butterfly butterfly = new Butterfly(randomPattern, randomColor, randomWings);
                tmp[i] = butterfly;
            }
            parents.add(tmp);
            numParents--;
        }

        return parents;
    }
}