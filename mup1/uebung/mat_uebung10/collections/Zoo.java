package collections;

import java.util.*;


/*
tiere ist die Liste aller Tiere im Zoo.
artenZaehler soll für jede Tierart zählen, wie häufig sie im Zoo vorkommt.

addTier soll das übergebene Tier zur Liste aller Tiere hinzufügen und den Artenzählen aktualisieren.

getTierbabies soll eine Liste aller Tiere, die jünger sind als 100 Tage, zurückgeben.

artenzaehlerToString soll einen String zurückgeben, der tabellarisch die Häufigkeit jeder Tierart
angibt. Beispiel:
Löwe: 4 mal
Tiger: 13 mal
Elefant: 2 mal

ausgabeTiere soll alle Tiere im Zoo ausgeben. Die Ausgabe soll dabei in der Reihenfolge erfolgen, wie
sie durch die Sortierfunktion der Klasse Tier vorgegeben ist. tiere soll nicht verändert werden.
 */
public class Zoo
{
    private List<Tier> tiere;
    private Map<String,Integer> artenZaehler;

    public Zoo()
    {
        tiere = new ArrayList<>();
        artenZaehler = new TreeMap<>();
    }


    public void addTier(Tier neuesTier)
    {
        tiere.add(neuesTier);

        String art = neuesTier.getArt();
        int neueHaeufigkeit = 1;
        if (artenZaehler.containsKey(art))
        {
            neueHaeufigkeit = artenZaehler.get(art) + 1;
        }
        artenZaehler.put(art, neueHaeufigkeit);
    }


    public List<Tier> getTierbabies()
    {
        List<Tier> babies = new ArrayList<>();
        for (Tier tier: tiere)
        {
            if (tier.getAlter() < 100)
            {
                babies.add(tier);
            }
        }
        return babies;
    }


    public String artenzaehlerToString()
    {
        StringBuilder sb = new StringBuilder("Vorhandene Tierarten:");
        for (String art: artenZaehler.keySet())
        {
            sb.append(art);
            sb.append(": ");
            sb.append(artenZaehler.get(art));
            sb.append(" mal\n");
        }
        return sb.toString();
    }


    public void ausgabeTiere()
    {
        List<Tier> kopie = new ArrayList<>(tiere);
        Collections.sort(kopie);
        for (Tier tier: kopie)
        {
            System.out.println(tier);
        }
    }

}
