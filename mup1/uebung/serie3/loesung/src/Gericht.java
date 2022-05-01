import java.util.ArrayList;
import java.util.List;

public class Gericht implements Comparable<Gericht>
{
    private List<Zutat> zutaten;
    private double preis;

    //Constructor
    public Gericht () {
        this.preis = 1.0;
        this.preis = preis;
        zutaten = new ArrayList<>();
    }

    //Zutaten hinzufuegen
    public void addZutat(Zutat neueZutat)
    {
        zutaten.add(neueZutat);
        this.preis += neueZutat.getPreis();
    }

    //Zutaten abfragen
    public boolean hatZutat(Zutat zutat)
    {
        return zutaten.contains(zutat);
    }

    //Name zusammenbauen aus Zutaten
    public String getName()
    {
        StringBuilder gerichtName = new StringBuilder();
        for (Zutat zutat: zutaten)
        {
            String nameZutat = zutat.getName();
            gerichtName.append(nameZutat, 0, 3);

            //Alternative mit .substring()
            //gerichtName.append(nameZutat.substring(0, 3));
        }
        return gerichtName.toString();
    }

    //Test ob nur vegane Gerichte
    public boolean istVegan()
    {
        for (Zutat einzelneZutat: zutaten)
        {
            //Hilfsvariable (unnuetz)
            boolean test_vegan = einzelneZutat.getVegan();
            if (!test_vegan) return false;
        }
        return true;
    }

    // Compare to Methode
    public int compareTo(Gericht vergleichsGericht)
    {
        /* Ausfuehrlich

        if (vergleichsGericht.preis > this.preis) {
            return -1;
        } else if (vergleichsGericht.preis < this.preis) {
            return 1;
        } else {
            return 0;
        }
        */

        //Alternativ
        return Double.compare(this.preis, vergleichsGericht.preis);
    }

    // new toString Method
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append(this.getName()).append(" ");

        if (this.istVegan()) { result.append("(vegan)").append(" "); }

        for (Zutat zutat : zutaten) {
            result.append(zutat.getName()).append(" ");
        }

        return String.format("%s%.2f Euro\n", result.toString(), this.preis);
    }
}
