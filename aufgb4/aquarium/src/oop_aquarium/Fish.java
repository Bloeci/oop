package oop_aquarium;

public class Fish {
    private java.lang.String name;
    private int price;
    private String[] intolerance;

    /**
     * Construtor of the fish class. A fish has a name, a price and
     * a list of fishes with which they must not be kept together.
     * @param name  Name of the fish
     * @param price Price of the fish
     * @param intolerance   Fish intolerance
     */
    public Fish(java.lang.String name, int price, String[] intolerance) {
        this.name = name;
        this.price = price;
        this.intolerance = intolerance;
    }

    /**
     * Getter for the fish name.
     * @return  Name of the fish (String).
     */
    public java.lang.String getName(){
        return this.name;
    }

    /**
     * Getter for the fish price.
     * @return Price (int) of the fish.
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Get a list of fishes which they must not be kept together.
     * @return List of fishes.
     */
    public String[] getIntolerance(){
        return this.intolerance;
    }

    @Override
    public String toString(){
        return this.name + ", Price: " + this.price;
//        return this.name;
    }
}
