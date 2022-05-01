import myExceptions.*;

import java.io.File;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US); // Points in decimal numbers

        // Tasks ----------------------------------------------------
        BuchstabenStat buchstabenStat = new BuchstabenStat();
        String inputFile = "Faust.txt";

        try{
            buchstabenStat.analysiere(inputFile);
            // Zusatz
            buchstabenStat.zeigeTop10();

            // Output-File - nur wenn ".txt" bereits gefunden worden ist
            buchstabenStat.schreibeStatistik(inputFile);

        } catch (UngueltigesZeichenException | FalscherDatentypException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

}
