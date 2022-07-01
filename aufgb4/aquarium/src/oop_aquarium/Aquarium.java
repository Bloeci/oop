package oop_aquarium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Class to generate a shopping list of fishes based on tolerances.
 */
public class Aquarium {
    private ArrayList<Fish> fishes;

    /**
     * Constructor of the aquarium class. Takes a list of fishes
     * as input to generate a maximum list of fishes.
     * @param fishes    List of fishes.
     */
    public Aquarium(ArrayList<Fish> fishes){
        this.fishes = fishes;
    }

    /**
     * Generate optimal lists for a given price, which are tolerated each other,
     * @param price Maximum money to buy fishes.
     */
    public void generateShoppingList(int price){
        ArrayList<ArrayList<Fish>> result = new ArrayList<>();

        for (Fish startFish : this.fishes) {
            ArrayList<Fish> currentFishList = new ArrayList<>();
            currentFishList.add(startFish);
            System.out.println(startFish.toString());

            ArrayList<ArrayList<Fish>> partlyResult = new ArrayList<>();
            partlyResult = addFish(currentFishList, this.fishes, price - startFish.getPrice(), partlyResult);

            // find (one) list with maximum length
            int maxLength = 0;
            for (ArrayList<Fish> actualResult : partlyResult){
                if (actualResult.size() > maxLength){
                    maxLength = actualResult.size();
                }
                // System.out.println(actualResult.toString());
            }

            System.out.printf("maximum length:%d\n", maxLength);
            for (ArrayList<Fish> actualResult : partlyResult){
                if (actualResult.size() == maxLength){
                    System.out.println(actualResult.toString());
                }
            }

            System.out.println();
        }
    }

    /**
     * Recursive algorithm to generate a list of fish lists, which contain only fishes, who are
     * tolerant to each other
     * @param fishList  actual list of fishes, on which the algorithm work
     * @param remainingFish actual list of fishes, on which new fishes were searched
     * @param money remaining money
     * @param completeList  complete List of fish list
     * @return  A list of fish list, for which every fish is tolerant to each other
     */
    public ArrayList<ArrayList<Fish>> addFish(ArrayList<Fish> fishList, ArrayList<Fish> remainingFish,
                                              int money, ArrayList<ArrayList<Fish>> completeList) {

        // create a new list of fish that can be added, check
        // tolerance and the name (not added if same name)
        Fish lastAddedFish = fishList.get(fishList.size() - 1);
        ArrayList<Fish> updatedRemainingFishes = new ArrayList<>();
        for (Fish potentialAddFish : remainingFish){
            if (checkTolerance(lastAddedFish, potentialAddFish) &&
                    !lastAddedFish.getName().equals(potentialAddFish.getName())){
                updatedRemainingFishes.add(potentialAddFish);
            }
        }

        // break condition 1 & 2: no more money or empty remaining fish list
        if (money == 0 || updatedRemainingFishes.isEmpty()){
            completeList.add(fishList);
            return completeList;
        }

        // there are fishes left, can only be added if enough remaining money
        // check variable to check if any fish was added
        boolean checkAdd = false;
        for (Fish tolerantFish : updatedRemainingFishes){
            if (money - tolerantFish.getPrice() >= 0) {
                ArrayList<Fish> tmpFishlist = new ArrayList<>(fishList);
                tmpFishlist.add(tolerantFish);
                completeList = addFish(tmpFishlist, updatedRemainingFishes,
                        money - tolerantFish.getPrice(), completeList);

                checkAdd = true;
            }
        }

        // only add fish list if no other fish was added
        if (!checkAdd){
            completeList.add(fishList);
        }
        return completeList;
    }

    /**
     * Helper function to check if two fishes are tolerant to each other
     * @param mainFish  One fish with a list of tolerated fishes
     * @param addFish   The fish we want to add
     * @return  Boolean if fish can be added
     */
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
