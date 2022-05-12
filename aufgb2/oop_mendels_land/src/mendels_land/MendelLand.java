package mendels_land;
import java.util.*;

public class MendelLand {
    private int numberOfParents;
    private String[] patterns;
    private String[] colors;
    private String[] shapes;
    private ArrayList<Butterfly[]> parents;
    private ArrayList<ChildPopulation> childPopulations;
    private int totalNumberOfButterflies;
    private Map<String, Integer> statistic;


    /**
     * Constructor of the mendelLand class.
     */
    public MendelLand(String[] patterns, String[] colors, String[] shapes, int numberOfParents){
        // Basic parameters
        this.numberOfParents = numberOfParents;
        this.patterns = patterns;
        this.colors = colors;
        this.shapes = shapes;

        // generate children and population
        this.parents = generateRandomParents(numberOfParents);
        this.childPopulations = generatePopulationByParents(parents);
        this.totalNumberOfButterflies = 0;
        for (ChildPopulation population : this.childPopulations){
            this.totalNumberOfButterflies += population.getNumberOfButterflies();
        }

        this.statistic = new HashMap<String, Integer>();
    }

    /**
     * Generate n random parents pairs.
     * @param numParents Number of total parent pairs.
     * @return parents  List of parents (pair of mother and father).
     */
    private ArrayList<Butterfly[]> generateRandomParents(int numParents){
        ArrayList<Butterfly[]> parents = new ArrayList<Butterfly[]>();
        Random rand = new Random();
        // generate random parents
        while (numParents > 0){
            Butterfly[] tmp = new Butterfly[2];
            for (int i = 0; i < 2; i++){
                String randomPattern = this.patterns[rand.nextInt(this.patterns.length)];
                String randomColor = this.colors[rand.nextInt(this.colors.length)];
                String randomWings = this.shapes[rand.nextInt(this.shapes.length)];

                Butterfly butterfly = new Butterfly(randomPattern, randomColor, randomWings);
                tmp[i] = butterfly;
            }
            parents.add(tmp);
            numParents--;
        }

        return parents;
    }

    /**
     * Generate the whole population based on the input parent list. Is
     * used by the constructor.
     * @param parents   List of mothers and father. List-of-lists.
     * @return population
     */
    private ArrayList<ChildPopulation> generatePopulationByParents(ArrayList<Butterfly[]> parents){
        ArrayList<ChildPopulation> population = new ArrayList<>();
        for (Butterfly[] butterflies : parents){
            ChildPopulation children = new ChildPopulation(butterflies[0], butterflies[1]);
            population.add(children);
        }

        return population;
    }

    /**
     * Getter for the child populations.
     * @return list An arraylist of all child populations.
     */
    public ArrayList<ChildPopulation> getChildPopulations() {
        return childPopulations;
    }

    /**
     * Getter for the total number of all butterflies in all populations.
     * @return totalNumberOfButterflies
     */
    public int getTotalNumberOfButterflies(){
        return this.totalNumberOfButterflies;
    }

    /**
     * Generate statistic based on the random population. Iterate threw all
     * subpopulations from the different parents, select unique butterflies
     * attributes and increase some counters.
     */
    private void generateStatistic(){
        // iterate threw all subpopulations and count unique butterflies
        for (int i = 0; i < this.numberOfParents; i++){
            ChildPopulation population = this.childPopulations.get(i);

            for (Butterfly butterfly : population.getChildren()) {
                if (!statistic.containsKey(butterfly.toString())) {
                    statistic.put(butterfly.toString(), 1);
                } else {
                    statistic.put(butterfly.toString(), statistic.get(butterfly.toString()) + 1);
                }
            }
        }
    }


    /**
     * Print the statistic of the n populations based on the n parent pairs. The
     * statistic contains the number of butterflies with the same attribute in
     * total, the percentage of the total population and the corresponding
     * attribute (patterns, colors and wings shapes).
     */
    public void showStatistic() {
        System.out.printf("""
                ************************************************************
                **               WELCOME TO MENDEL LAND                   **
                ************************************************************
                Lets analyse %d population(s) with %d children in total.
                """, this.numberOfParents, this.totalNumberOfButterflies);
        this.generateStatistic();

        if (!this.statistic.isEmpty()){
            // sort the hashmap with a new list of Map.Entries, reverse afterwards
            List<Map.Entry<String, Integer>> pairButterfly = new ArrayList<>(statistic.entrySet());
            pairButterfly.sort(Map.Entry.comparingByValue());
            Collections.reverse(pairButterfly);

            System.out.print("""
                    Statistic
                    =======================================================
                    Counts      percent     Butterflies attributes
                    -------------------------------------------------------
                    """);
            for (Map.Entry<String, Integer> butterflyEntry : pairButterfly) {
                float percent = (butterflyEntry.getValue() / (float) this.totalNumberOfButterflies) * 100;
                System.out.printf("%-5d\t\t%.2f%%\t\t%s\n",
                        butterflyEntry.getValue(), percent, butterflyEntry.getKey()
                );
            }
        } else {
            System.out.println("[Warning] No analysis performed yet. Something happened");
        }
    }
}
