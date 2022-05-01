package vererbung;

/*
Die Klasse Sammlung besitzt ein Attribut medien vom Typ List<Medium>, um Medien speichern zu können.

Die gespeicherten Medien sollen bei der Erzeugung einer Sammlung übergeben werden.

Die Methode berechneGesamtlaufzeit soll die gesamte Laufzeit aller Medien in der Sammlung, die eine Laufzeit
besitzen, berechnen und zurückgeben.
 */
import java.util.List;

public class Sammlung
{
    private List<Medium> medien;

    public Sammlung(List<Medium> medien)
    {
        this.medien = medien;
    }


    public double berechneGesamtlaufzeit()
    {
        double laufzeitGesamt = 0.0;
        for (Medium medium: medien)
        {
            if (medium instanceof Laufzeit)
            {
                laufzeitGesamt += ((Laufzeit)medium).getLaufzeit();
            }
        }
        return laufzeitGesamt;
    }
}
