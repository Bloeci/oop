package aufgabe1_nim_spiel;

public class Computer extends Player {
    public Computer() {
        super();
    }

    /**
     * Computer function to choose the stones, which will be taken from the stack.
     * Optimal strategy is to take k Tokens from formula:
     * k = (N + M) mod (M+1), with N - Total number of tokens, M - maximal number
     * of tokens which can be taken
     * @param remainStones int
     * @return chosenNumber int
     */
    @Override
    public int choseNumberOfStones(int remainStones) {
        int optimal = (remainStones + 3) % 4;
        if (optimal == 0) {
            // chose random stones if computer can't choose optimal number
            optimal = (int)(Math.random() * 2) + 1;

        }
        System.out.printf("The computer takes %d stone(s).\n", optimal);
        return optimal;
    }
}
