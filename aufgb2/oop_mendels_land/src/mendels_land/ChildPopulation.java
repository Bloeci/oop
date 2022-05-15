package mendels_land;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChildPopulation {
    private int numberOfButterflies;
    private Butterfly mother;
    private Butterfly father;
    private List<Butterfly> child;

    /**
     * Constructor of a new collection of butterfly children based on the
     * attributes from the mother and father. The class generated a random
     * number between 1000 and 2000 children.
     * @param mother    Butterfly class
     * @param father    Butterfly class
     */
    public ChildPopulation(Butterfly mother, Butterfly father){
        this.mother = mother;
        this.father = father;
        this.numberOfButterflies = randomNumberOfChildren(1000, 2000);
        this.child = generateChildren();
    }

    /**
     * Getter for the number of children.
     * @return number   Actual number of children
     */
    public int getNumberOfChildren() {
        return numberOfButterflies;
    }


    /**
     * Getter for the actual children population.
     * @return children     List of butterfly children.
     */
    public List<Butterfly> getChildren(){
        return this.child;
    }

    /**
     * Getter of the father butterfly.
     * @return father   Butterfly class of the father
     */
    public Butterfly getFather() {
        return father;
    }


    /**
     * Getter of the mother butterfly.
     * @return mother   Butterfly class of the mother
     */
    public Butterfly getMother() {
        return mother;
    }

    /**
     * Generate random number between 1000-2000 (inclusive) for number of
     * butterfly children.
     * @return  int     number of children
     */
    public int randomNumberOfChildren(int min, int max) {
        // return (int)(Math.random() * (2000 + 1 - 1000)) + 1000;
        return (int)(Math.random() * (max + 1 - min)) + min;
    }

    /**
     * Create a List of children with random attributes.
     * @return butterflies   A list of butterfly children based on the
     *                      attributes of the mother and father.
     */
    private List<Butterfly> generateChildren(){
        String[] patterns = new String[]{this.mother.getPattern(), this.father.getPattern()};
        String[] colors = new String[]{this.mother.getWingColor(), this.father.getWingColor()};
        String[] shapes = new String[]{this.mother.getWingShape(), this.father.getWingShape()};

        ArrayList<Butterfly> butterflies = new ArrayList<Butterfly>();

        Random rand = new Random();
        int counter = 0;
        while (counter < this.numberOfButterflies) {
            String pattern = patterns[rand.nextInt(2)];
            String color = colors[rand.nextInt(2)];
            String wingShape = shapes[rand.nextInt(2)];

            Butterfly child = new Butterfly(pattern, color, wingShape);
            butterflies.add(child);
            counter++;
        }

        return butterflies;
    }
}
