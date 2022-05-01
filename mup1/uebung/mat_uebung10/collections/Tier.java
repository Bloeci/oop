package collections;

/*
Die Klasse Tier soll das Comparable-Interface implementieren.

name ist der Name des Tieres. art gibt die Tierart und alter das Alter in Tagen an.

compareTo soll zuerst die Art lexikographisch vergleichen. Ist die Art bei beiden
Tieren gleich, dann soll der Name lexikographisch verglichen werden.

toString soll die Informationen über ein Tier in folgendem Format zurückgeben:
<Art> <Name>, <Alter> Tage alt
 */
public class Tier implements Comparable<Tier>
{
    private String name;
    private String art;
    private int alter;

    public Tier(String name, String art, int alter)
    {
        this.name = name;
        this.art = art;
        this.alter = alter;
    }

    public int compareTo(Tier vergleichsobjekt)
    {
        if (vergleichsobjekt.art.equals(this.art))
        {
            return name.compareTo(vergleichsobjekt.name);
        }
        return art.compareTo(vergleichsobjekt.art);
    }

    public String toString()
    {
        return String.format("%s %s, %d Tage alt", art, name, alter);
    }

    public String getName()
    {
        return name;
    }

    public String getArt()
    {
        return art;
    }

    public int getAlter()
    {
        return alter;
    }
}
