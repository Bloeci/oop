import oop_aquarium.Aquarium;
import oop_aquarium.Fish;

import java.util.ArrayList;

public class Main {
    public static void main(java.lang.String[] args) {
        ArrayList<Fish> tmp = generateFishes();

        Aquarium aquarium = new Aquarium(tmp);
        aquarium.generateOptimalList(270);

        for (ArrayList<Fish> fishes : aquarium.getRecursiveFishList()){
            System.out.print('[');
            for (Fish fish : fishes){
                System.out.printf("%s, ", fish.getName());
            }
            System.out.println("]");
        }
    }

    private static ArrayList<Fish> generateFishes() {
        String grueneMigraene = "Gruene Migraene";
        String korallenqualle = "Korallenqualle";
        String schuppenschatulle = "Schuppenschatulle";
        String breitmaulfrosch = "Breitmaulfrosch";
        String prachtpiranha = "Prachtpiranha";
        String zitterling = "Zitterling";
        String grottensprotte = "Grottensprotte";

        // Generate some fishes
        Fish fish1 = new Fish(grueneMigraene, 70, new String[]{breitmaulfrosch, grottensprotte});
        Fish fish2 = new Fish(korallenqualle, 50, new String[]{});
        Fish fish3 = new Fish(schuppenschatulle, 30, new String[]{breitmaulfrosch, prachtpiranha});
        Fish fish4 = new Fish(breitmaulfrosch, 40, new String[]{grueneMigraene, schuppenschatulle});
        Fish fish5 = new Fish(prachtpiranha, 40, new String[]{schuppenschatulle, grottensprotte});
        Fish fish6 = new Fish(zitterling, 30, new String[]{grottensprotte});
        Fish fish7 = new Fish(grottensprotte, 20, new String[]{grueneMigraene, prachtpiranha, zitterling});

        // Add fishes to list
        ArrayList<Fish> fishes = new ArrayList<Fish>();
        fishes.add(fish1);
        fishes.add(fish2);
        fishes.add(fish3);
        fishes.add(fish4);
        fishes.add(fish5);
        fishes.add(fish6);
        fishes.add(fish7);
        return fishes;
    }
}