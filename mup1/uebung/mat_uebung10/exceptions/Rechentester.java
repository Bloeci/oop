package exceptions;
/*
Die Methode teste(zahl, basis) der Klasse Rechentester soll das Ergebnis der Berechnung
Rechner.log(zahl, basis) ausgeben. Alle auftretenden Ausnahmen sollen so behandelt werden,
dass eine entsprechende Fehlermeldung auf der Fehlerkonsole System.err ausgegeben wird.
Unabhöngig davon, ob eine Ausnahme behandelt wurde oder nicht, sollen zum Schluss
die Parameter der Methode ausgegeben werden.
 */
public class Rechentester
{
    public static void teste(double zahl, double basis)
    {
        try
        {
            System.out.println("Ergebnis: " + Rechner.log(zahl, basis));
        }
        catch (BaseException e)
        {
            System.err.println("Die Basis war fehlerhaft.");
        }
        catch (NumberException e)
        {
            System.err.println("Die Zahl war fehlerhaft.");
        }
        finally {
            System.err.println(String.format("Parameter: zahl=%f, basis=%f", zahl, basis));
        }
    }
}
