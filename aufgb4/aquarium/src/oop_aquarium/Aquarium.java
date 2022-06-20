package oop_aquarium;

import java.util.ArrayList;

public class Aquarium {
    private ArrayList<Fish> fishes;
    private ArrayList<ArrayList<Fish>> recursiveFishList;

    /**
     * Contructor of the aquarium class. Takes a list of fishes
     * as input to generate an maximum list of fishes.
     * @param fishes    List of fishes.
     */
    public Aquarium(ArrayList<Fish> fishes){
        this.fishes = fishes;
        this.recursiveFishList = new ArrayList<>();
    }

    public ArrayList<ArrayList<Fish>> getRecursiveFishList(){
        return this.recursiveFishList;
    }

    public void generateOptimalList(int price){
//        for (Fish fish : this.fishes){
//            ArrayList<Fish> partlyResult = new ArrayList<>();
//            partlyResult.add(fish);
//            addFish(partlyResult, price - fish.getPrice());
//        }
        ArrayList<Fish> partlyResult = new ArrayList<>();
        partlyResult.add(this.fishes.get(0));
        addFish(partlyResult, price - this.fishes.get(0).getPrice());
    }

    private void addFish(ArrayList<Fish> fishList, int money) {
        // create a new list of fish that can be added
        // BC List as value are updated outside
        ArrayList<Fish> remainFish = new ArrayList<>();
        for (Fish potentialFish : this.fishes){
            for (Fish actualFish : fishList){
                if (!potentialFish.getName().equals(actualFish.getName()) &&
                        checkTolerance(potentialFish, actualFish)){
                    remainFish.add(potentialFish);
                }
            }
        }

        // break condition: empty remaining fishes or money equals 0
        if (remainFish.isEmpty() || money == 0) {
            this.recursiveFishList.add(fishList);
        }
        // last fish was too much for our budget
        if (money < 0) {
            fishList.remove(fishList.size() - 1);
            this.recursiveFishList.add(fishList);
        }

        // create new list
        for (Fish fish : remainFish){
            ArrayList<Fish> tmp = new ArrayList<>(fishList);
            tmp.add(fish);
            addFish(tmp, money - fish.getPrice());
        }

    }

    private boolean checkTolerance (Fish mainFish, Fish addFish){
        // empty intolerance
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
