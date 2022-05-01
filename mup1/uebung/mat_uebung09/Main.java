import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{    public static void main(String[] args)
    {
        System.out.println("Arbeiten mit Interfaces (geometrische Formen):\n==========================================");
        List<GeometrischeForm> formen = new ArrayList<>();
        formen.add(new Kreis(1));
        formen.add(new Rechteck(3, 4));
        formen.add(new RegelmaessigesNEck(8, 1));
        for (GeometrischeForm form: formen)
        {
            System.out.println(String.format("Die geometrische Form hat %d Ecken, eine Fläche von %.3f und einen Umfang von %.3f.",
                    form.anzahlEcken(), form.berechneFlaeche(), form.berechneUmfang()));
        }


        System.out.println("\nPseudocode Beispiel 1 (Addition zweier Liste):\n==========================================");
        int[] listeA = {1,3,5,7,9};
        int[] listeB = {-10,10,20,30,40};
        Pseudocode.paarSumme(listeA, listeB);

        System.out.println("\nPseudocode Beispiel 2 (Bubblesort):\n==========================================");
        int[] listeC = {5,1,6,11,-3,193,0,-32,};
        Pseudocode.bubbleSort(listeC);

        System.out.println("\nPseudocode Beispiel 3 (rekursives Filtern):\n==========================================");
        List<Integer> listeD = new ArrayList<>(Arrays.asList(13,28,81,-20,-10,22,3,0,17,4,111));
        int schwellwert = 10;
        System.out.println(String.format("Anzahl der Elemente groesser gleich %d in der Liste: %d", schwellwert, Pseudocode.groesserAls(listeD, 10)));
    }
}
