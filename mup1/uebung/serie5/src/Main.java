import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US); // Points in decimal numbers

        // Tasks ------------
        // Create nodes
        Knoten d = new Knoten(1.0);
        Knoten e = new Knoten(5.3);
        Knoten f = new Knoten(9.2);
        Knoten b = new Knoten(4.4, Arrays.asList(d, e));
        Knoten c = new Knoten(3.1, Arrays.asList(null, f));
        Knoten wurzel = new Knoten(7.0, Arrays.asList(b, c));

        // Create operator
        Summe summe = new Summe();
        Durchschnitt durchschnitt = new Durchschnitt();

        // Make Trees
        BaumProzessor summeBaum = new BaumProzessor(wurzel, summe);
        BaumProzessor durchschnittsBaum = new BaumProzessor(wurzel, durchschnitt);

        // Do something
        summeBaum.berechneErgebnis();
        durchschnittsBaum.berechneErgebnis();

    }
}
