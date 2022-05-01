package vererbung;

/*
Die Klasse Album soll von der Klasse Medium erben und das Interface Laufzeit implementieren.

Sie besitzt die Attribute laufzeit vom Typ double und interpret vom Typ String.

Die Methode toString() soll folgenden String zurückgeben:
Mediennummer: <mediennummer>, Titel: <titel>, Laufzeit: <laufzeit>, Interpret: <interpret>
 */
public class Album extends Medium implements Laufzeit
{
    private double laufzeit;
    private String interpret;

    public Album(int mediennummer, String titel, double laufzeit, String interpret)
    {
        super(mediennummer, titel);
        this.laufzeit = laufzeit;
        this.interpret = interpret;
    }


    public String toString()
    {
        return String.format("%s, Laufzeit: %.2f, Interpret: %s", super.toString(), laufzeit, interpret);
    }


    @Override
    public double getLaufzeit()
    {
        return laufzeit;
    }
}
