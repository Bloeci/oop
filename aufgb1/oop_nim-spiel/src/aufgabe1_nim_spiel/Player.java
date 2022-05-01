package aufgabe1_nim_spiel;

import java.util.Scanner;

public class Player implements Basics {
    private String name;
    private int wonGames;
    private boolean isReel;

    public Player() {
        this.name = "Computer";
        this.wonGames = 0;
        this.isReel = false;
    }

    public Player(String name) {
        this.name = name;
        this.wonGames = 0;
        this.isReel = true;
    }

    /**
     * Getter for the player name.
     * @return player name String
     */
    public String getName() { return this.name; }

    /**
     * Getter for the number of games won.
     * @return number of games won int
     */
    public int getWonGames() { return this.wonGames; }

    /**
     * Add one to the games won.
     */
    public void addWonGames() { this.wonGames += 1; }

    /**
     * Get information if player is real or a dump computer
     * @return this.isReel boolean
     */
    public boolean isReel() {
        return this.isReel;
    }

    /**
     * Get user input to choose a number of stones, which are taken from the remaining
     * stack. The user should only choose integer numbers 1, 2 or 3.
     * @param   remainStones    integer number of remaining stones
     * @return  chosen number
     */
    public int choseNumberOfStones(int remainStones) {
        Scanner scanner = new Scanner(System.in);
        boolean rightNumber = false;
        int validateNumber;
        int choseNumber = -1;

        // let rightNumber to flag
        while (!rightNumber) {
            System.out.printf("Remaining stones:\t%d\n", remainStones);
            // worst case, only one stone remain
            if (remainStones == 1) {
                System.out.println("Sorry, you can only chose the last remaining stone. You lose.");
                return 1;
            }

            // other cases
            System.out.print("How much stones do you wanna take from stack: ");
            // check chosen number
            try {
                choseNumber = Integer.parseInt(scanner.next()); // try to parse input to integer
                if (choseNumber > 0 && choseNumber < 4) {
                    validateNumber = remainStones - choseNumber;
                    if (validateNumber > 0) {
                        rightNumber = true;
                    } else {
                        System.out.println("[Attention] There are not that many stones left. Try again.");
                        System.out.println("-----------------------------------------------------------");
                    }
                } else {
                    System.out.println("[Attention] A minimum of one and a maximum of three are allowed. Try again.");
                    System.out.println("---------------------------------------------------------------------------");
                }

            } catch (NumberFormatException ex) {
                System.out.println("[Attention] Only integer numbers are allowed. Try again.");
                System.out.println("--------------------------------------------------------");
            }

        }

        return choseNumber;
    }
}
