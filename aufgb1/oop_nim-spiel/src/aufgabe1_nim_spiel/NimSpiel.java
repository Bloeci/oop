package aufgabe1_nim_spiel;

import java.util.*;

public class NimSpiel {
    private int numberStones;
    private int numberOfGames;
    private Player player;
    private Computer computer;

    public NimSpiel() {
        this.numberStones = randomNumberStones();
        this.numberOfGames = 0;
    }

    /**
     * Generate random number between 20-30 (inclusive) for number of stones.
     * @return  int     number of stones
     */
    public int randomNumberStones() {
        return (int)(Math.random() * (30 + 1 - 20)) + 20;
    }

    /**
     *  Start game for 'nim spiel'. Will ask first for the name of the player and
     *  the number of stones, which are taken from the stack by the player in his/her first
     *  move. After that the game loop starts with an extra function to run multiple
     *  games after each other.
     */
    public void startGame() {

        printRules(); // print the rules of this game
        String userName = validPlayerName();

        // initialize player with name and computer
        this.player = new Player(userName);
        this.computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gameLoop(this.player, this.computer);
            this.numberOfGames += 1;

            printStatistics();

            // ask player if he/she wants to play another round
            System.out.print("\n Do you wanna play another round? [yes/no, y/n]\n Answer:");
            while (!scanner.hasNext("(y|yes|n|no)")) {
                System.out.print("What did you say? Please answer yes/y or no/n.\n Answer:");
                scanner.next();
            }
            String answer = scanner.next();
            answer = answer.toLowerCase(); // get sure, that answer can be read (YES/NO)
            if (!answer.equals("yes") && !answer.equals("y")) {
                System.out.println("Thanks for playing. Goodbye.");
                break;
            } else {
                this.numberStones = randomNumberStones();
            }

        }
    }

    /**
     * Main game loop. First player will be chosen at random
     * @param player    player who plays, he can interact in game
     * @param computer  computer player
     */
    private void gameLoop(Player player, Computer computer) {

        // chose random start player
        int randomPlayer = (int)Math.round(Math.random());
        Player firstPlayer, secondPlayer, winner;

        if (randomPlayer == 1) {
            firstPlayer = player;
            secondPlayer = computer;
        } else {
            firstPlayer = computer;
            secondPlayer = player;
        }

        // store player in array (because of task notes, not necessary)
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(firstPlayer);
        playerList.add(secondPlayer);

        // game loop
        System.out.printf("""

                --------------------------
                | Start Game | %d stones |
                --------------------------
                """, this.numberStones);


        int tokens; // tokens, which were taken from stack (stones)
        int rounds = 0; // keep track of playing rounds
        int playerIndex = 0; // player index
        while (true) {
            Player actualPlayer = playerList.get(playerIndex);
            System.out.printf("Actual Player: %s\n", actualPlayer.getName());

            // let 'him' play
            tokens = actualPlayer.choseNumberOfStones(this.numberStones);
            this.numberStones -= tokens;
            rounds++;
            if (this.numberStones == 0) {
                winner = playerList.get((playerIndex + 1) % 2); // next player is winner
                winner.addWonGames();
                break;
            } else {
                System.out.println("-------------------------------------------------");
            }

            playerIndex = (playerIndex + 1) % 2;
         }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("\nThe Game ends after %d rounds and the winner is:\n", rounds);
        if (winner.isReel()) {
            System.out.printf("\t You! You have won %s. Congratulations!\n\n", winner.getName());
        } else {
            System.out.println("\t ... the computer. Im sorry (Muhahaha).\n");
        }
    }


    /**
     * Function to validate the player input name, which should only contain letters in
     * upper- or lowercase.
     * @return  string      name of the player if he enters a valid name
     */
    private String validPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("You wanna try to beat the computer?\n" +
                "Enter your name (only letters): ");

        // check with scanner, if entered name only contains letters and whitespace
        while (!scanner.hasNext("[a-zA-Z\s]+")) {
            System.out.print("""

                    You dont enter a valid name. Try again!
                    Enter your name (only letters):\s""");
            scanner.next();
        }

        // return scanner.next() as username
        return scanner.next();
    }

    public void printStatistics() {
        System.out.printf("Total score after %d game(s):\n\tComputer\t%d\n\tPlayer %s \t%d\n\n", this.numberOfGames,
                this.computer.getWonGames(), this.player.getName(), this.player.getWonGames());
    }


    /**
     * Print the rules of the 'nim spiel'.
     */
    public static void printRules() {
        String rules;
        rules = """
                *******************************************************************************
                **                                 NIM SPIEL                                 **
                *******************************************************************************
                Goal: The goal of this game is not to have to take the last stone from a stack.
                Rules:\s
                  1) In every step each player must take at least one stone from the stack.
                  2) The maximum number of stones a player can take is 3.
                  3) The player, who takes the last stone, lose.
                  4) At the beginning of the game the first player is chosen at random.
                -------------------------------------------------------------------------------
                """;
        System.out.println(rules);
    }
}
