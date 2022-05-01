package vererbung;

/*
Die Klasse Film soll von der Klasse Medium erben und das Interface Laufzeit implementieren.

Sie besitzt die Attribute laufzeit vom Typ int und regisseur vom Typ String.

Die Methode toString() soll folgenden String zurückgeben:
Mediennummer: <mediennummer>, Titel: <titel>, Laufzeit: <laufzeit>, Regisseur: <regisseur>
 */
public class Film extends Medium implements Laufzeit
{
    private double laufzeit;
    private String regisseur;

    public Film(int mediennummer, String titel, double laufzeit, String regisseur)
    {
        super(mediennummer, titel);
        this.laufzeit = laufzeit;
        this.regisseur = regisseur;
    }


    public String toString()
    {
        return String.format("%s, Laufzeit: %.2f, Regisseur: %s", super.toString(), laufzeit, regisseur);
    }


    public double getLaufzeit()
    {
        return laufzeit;
    }
}
