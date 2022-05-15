package mendels_land;

import java.util.ArrayList;
import java.util.Random;

public class ChildPopulation {
    private int numberOfButterflies;
    private Butterfly mother;
    private Butterfly father;
    private ArrayList<Butterfly> child;

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
        this.numberOfButterflies = randomNumberChild();
        // generate children population
        this.child = generateChildren();
    }

    /**
     * Getter for the number of children.
     * @return number   Actual number of children
     */
    public int getNumberOfButterflies() {
        return numberOfButterflies;
    }

    /**
     * Generate a new random sized children population based on the
     * actual mother and father butterfly.
     */
    public void generateNewPopulation() {
        this.numberOfButterflies = randomNumberChild();
        this.child = generateChildren();
    }

    /**
     * Generate a new random children population based on the
     * actual mother and father butterfly. Size of the
     * actual number of children.
     */
    public void newChildren() {
        this.child = generateChildren();
    }

    /**
     * Getter for the actual children population.
     * @return children     List of butterfly children.
     */
    public ArrayList<Butterfly> getChildren(){
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
     * Setter for the father butterfly. After that the barrel will generate
     * a new random children population with new attributes. Same population size.
     * @param father    New father of the children population.
     */
    public void setFather(Butterfly father) {
        this.father = father;
        this.child = generateChildren();
    }

    /**
     * Getter of the mother butterfly.
     * @return mother   Butterfly class of the mother
     */
    public Butterfly getMother() {
        return mother;
    }

    /**
     * Setter for the mother butterfly. After that the barrel will generate
     * a new random children population with new attributes. Same population size.
     * @param mother    New mother of the children population.
     */
    public void setMother(Butterfly mother) {
        this.mother = mother;
        this.child = generateChildren();
    }

    /**
     * Generate random number between 1000-2000 (inclusive) for number of
     * butterfly children.
     * @return  int     number of children
     */
    private int randomNumberChild() {
        // return (int)(Math.random() * (2000 + 1 - 1000)) + 1000;
        return (int)(Math.random() * (20 + 1 - 10)) + 10;
    }

    /**
     * Create a List of children with random attributes.
     * @return butterflies   A list of butterfly children based on the
     *                      attributes of the mother and father.
     */
    private ArrayList<Butterfly> generateChildren(){
        // initialize some lists for all attributes
        System.out.println("Generate children...");
        String[] patterns = new String[]{this.mother.getPattern(), this.father.getPattern()};
        String[] colors = new String[]{this.mother.getWingColor(), this.father.getWingColor()};
        String[] shapes = new String[]{this.mother.getWingShape(), this.father.getWingShape()};

        ArrayList<Butterfly> butterflies = new ArrayList<>();

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
