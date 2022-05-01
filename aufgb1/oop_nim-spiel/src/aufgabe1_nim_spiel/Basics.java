package aufgabe1_nim_spiel;

public interface Basics {

    // basic methods for all players (reel or computer) to implements
    public String getName();
    public void addWonGames();
    public int getWonGames();
    public int choseNumberOfStones(int remainStones);
    public boolean isReel();
}
