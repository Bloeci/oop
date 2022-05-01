import java.util.List;

public class Pseudocode
{
    /*
    gegeben: ein int-Array x und ein int-Array y
    FALLS die Länge von x ungleich der Länge von y:
        ENDE
    INITIALISIERE k mit 0
    INITIALISIERE wertX
    INITIALISIERE wertY
    SOLANGE k kleiner als die Länge von x ist:
        SETZE wertX auf das k-te Element von x
        SETZE wertY auf das k-te Element von y
        GEBE die Summe von wertX und wertY AUS
        erhöhe k um 1
     */
    public static void paarSumme(int[] x, int[] y)
    {
        if (x.length != y.length)
        {
            return;
        }
        int k = 0;
        int wertX;
        int wertY;
        while (k < x.length)
        {
            wertX = x[k];
            wertY = y[k];
            System.out.println(wertX + wertY);
            k++;
        }
    }



    /*
    gegeben: ein int-Array x
    INITIALISIERE k mit der Länge von x minus 1
    SOLANGE k größer gleich 1 ist:
        INITIALISIERE m mit k minus 1
        SOLANGE m größer gleich 0 ist:
            FALLS das k-te Element von x kleiner ist als das m-te Element von x:
                tausche das k-te Element von x und das m-te Element von x
            verringere m um 1
        verringere k um 1
    FÜR ALLE wert in x:
        GEBE wert AUS
     */
    public static void bubbleSort(int[] x)
    {
        int k = x.length - 1;
        while (k >= 1)
        {
            int m = k - 1;
            while (m >= 0)
            {
                if (x[k] < x[m])
                {
                    int temp = x[k];
                    x[k] = x[m];
                    x[m] = temp;
                }
                m--;
            }
            k--;
        }
        for (Integer i: x)
        {
            System.out.println(i);
        }
    }


    /*
    Methode groesserAls(x,n)
    gegeben: eine Liste von Integer x und ein int n
    FALLS x leer ist:
        GEBE 0 ZURÜCK
    INITIALISIERE r mit 0
    FALLS das 0-te Element von x groesser gleich n ist:
        SETZE r auf 1
    entferne das 0-te Element von x
    GEBE die Summe aus r und groesserAls(x,n) ZURÜCK
     */
    public static int groesserAls(List<Integer> x, int n)
    {
        if (x.isEmpty())
        {
            return 0;
        }
        int r = 0;
        if (x.get(0) >= n)
        {
            r = 1;
        }
        x.remove(0);
        return r + groesserAls(x, n);
    }

}
