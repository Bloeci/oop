package oop_aquarium;

import java.util.ArrayList;

public class Aquarium {
    private ArrayList<Fish> fishes;

    /**
     * Contructor of the aquarium class. Takes a list of fishes
     * as input to generate an maximum list of fishes.
     * @param fishes    List of fishes.
     */
    public Aquarium(ArrayList<Fish> fishes){
        this.fishes = fishes;
    }

    public void generateOptimalList(int price){
        ArrayList<ArrayList<Fish>> result = new ArrayList<>();
        for (Fish fish : this.fishes){
            continue;
        }
    }

    private ArrayList<Fish> addFish(ArrayList<Fish> fishList, ArrayList<Fish> remainFish, int money){
        // Break condition: money is empty of no fishes remain
        if (money <= 0 || remainFish.isEmpty()) return fishList;

    }

    private boolean checkTolerance (Fish mainFish, Fish addFish){
        // empty tolerance
        if (mainFish.getIntolerance().length == 0) return true;
        // check all fish names in tolerance list
        for (String fishName : mainFish.getIntolerance()){
            if (fishName.equals(addFish.getName())){
                return false;
            }
        }
        return true;
    }

}
