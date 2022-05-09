package mendels_land;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MendelLand {
    private Butterfly mother;
    private Butterfly father;
    private ChildPopulation children;

    private Map<String, ArrayList<String>> attributes;

    /**
     * Constructor of the mendelLand class.
     */
    public MendelLand(){
        System.out.println("Welcome to mendel land!");
        this.attributes = new HashMap<String, ArrayList<String>>();
        // fill map with attributes
        allPatterns();
        allWingColors();
        allWingShapes();

        // init main variables
        this.mother = getParentAttributes("mother");
        this.father = getParentAttributes("father");
        this.children = new ChildPopulation(mother, father);
    }

    public MendelLand(Butterfly mother, Butterfly father){
        System.out.println("Welcome to mendel land!");
        this.attributes = new HashMap<String, ArrayList<String>>();
        // fill map with attributes
        allPatterns();
        allWingColors();
        allWingShapes();

        // init main variables
        this.mother = mother;
        this.father = father;
        this.children = new ChildPopulation(mother, father);
    }

    /**
     * Getter for the child population.
     * @return children
     */
    public ArrayList<Butterfly> getChildren() {
        return children.getChildren();
    }

    /**
     * Returns a butterfly with attributes from user input.
     * @param parent    "mother" or "father"
     * @return butterfly
     */
    private Butterfly getParentAttributes(String parent){
        printAttributes();
        System.out.printf("What are the attributes of the %s?\n", parent);

        // ask for the three attributes of the actual parent
        String inputPattern = validInput("Pattern");
        String inputWingColor = validInput("Color");
        String inputShapes = validInput("Shape");
        return new Butterfly(inputPattern, inputWingColor, inputShapes);
    }

    /**
     * Method to validate the user input. Will be used by another method as
     * helper. Returns only attribute (string) if it is valid.
     * @param attribute Current attribute
     * @return selected attribute by user
     */
    private String validInput(String attribute){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s: ", attribute);
        // check with scanner, if entered name only contains letters and whitespace
        Boolean checkValid = false;
        while (!checkValid){
            if (!scanner.hasNext("^[a-zA-Z]+")) {
                System.out.printf("""
                    You dont enter a valid attribute. Try again!
                    %s Attribute (only letters): \s""", attribute);
                scanner.next();
            }

            // check if attribute is valid, exists in map
            String currentAttributeValue = scanner.next();
            ArrayList<String> currentAttribute = this.attributes.get(attribute);
            for (String attr : currentAttribute){
                if (currentAttributeValue.equals(attr)){
                    checkValid = true;
                }
            }

            if (!checkValid){
                System.out.printf("Your %s is not valid. See above for recommended %s.\n", attribute, attribute);
                System.out.printf("%s: ", attribute);
            }
        }
        // return scanner.next() as input
        return scanner.next();
    }

    /**
     * List of all accepted patterns.
     */
    private void allPatterns(){
        ArrayList<String> patterns = new ArrayList<String>();
        patterns.add("uniform");
        patterns.add("black points");
        patterns.add("black strips");
        // add to map
        this.attributes.put("Pattern", patterns);
    }

    /**
     * List of all accepted wing colors.
     */
    private void allWingColors(){
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("yellow");
        colors.add("green");
        colors.add("blue");
        // app to map
        this.attributes.put("Color", colors);
    }

    /**
     * List of all accepted wing shapes.
     */
    private void allWingShapes(){
        ArrayList<String> shapes = new ArrayList<String>();
        shapes.add("straight");
        shapes.add("curved");
        // add to map
        this.attributes.put("Shape", shapes);
    }

    /**
     * Output the attributes that the butterflies should have.
     */
    private void printAttributes(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Recommended attributes of our butterflies (seperated by comma)");
        for (String attribute : this.attributes.keySet()){
            ArrayList<String> values = this.attributes.get(attribute);
            System.out.printf("%s: ", attribute);
            // just two print statements, just for the comma
            for (int i = 0; i < values.size(); i++){
                if (i != (values.size() - 1)){
                    System.out.printf("%s, ", values.get(i));
                } else {
                    System.out.printf("%s\n", values.get(i));
                }
            }
        }
        System.out.println("-------------------------------------------------------------");
    }
}
