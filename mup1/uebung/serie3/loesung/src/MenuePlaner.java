import java.util.*;

public class MenuePlaner
{
    private List<Zutat> zutatenListe;
    private Map<String, List<Gericht>> speiseplan;

    // Constructor
    public MenuePlaner(Zutat[] zutatenArray) {
        zutatenListe = new ArrayList<Zutat>(Arrays.asList(zutatenArray));
        speiseplan = new HashMap<>();
    }

    // Erzeuge Zufallszahl zwischen [min, max] (inklusive)
    private int zufallszahl(int minimum, int maximum)
    {
        return (int)(Math.random() * (maximum + 1 - minimum)) + minimum;
    }

    // Erstelle Gericht anhand von Zutatenliste
    private Gericht erstelleGericht()
    {
        // Initialisierung
        int anzahlZutaten = zufallszahl(3, 5);
        int hinzugefuegt = 0;
        Gericht gericht = new Gericht();

        // Hinzufuegen von Zutaten
        while (hinzugefuegt < anzahlZutaten)
        {
            // Neue Variable eher unnoetig
            int zufaelligeZutatNr = zufallszahl(0, zutatenListe.size() - 1);
            Zutat zufaelligeZutat = zutatenListe.get(zufaelligeZutatNr);

            // Test ob Zutat schon im Gericht vorhanden ist
            if (!gericht.hatZutat(zufaelligeZutat)) {
                gericht.addZutat(zufaelligeZutat);
                hinzugefuegt++;
            }
        }
        return gericht;
    }

    // Menu erstellen für einen Wochentag, speichern in Map(key, value)
    private void erstelleMenuFuerWochentag(String tag, int anzahlGerichte)
    {
        int hinzugefuegteGerichte = 0;
        List<Gericht> listeGerichte = new ArrayList<>();

        while (hinzugefuegteGerichte < anzahlGerichte)
        {
            listeGerichte.add(erstelleGericht());
            hinzugefuegteGerichte ++;
        }

        speiseplan.put(tag, listeGerichte);
    }

    // Festen Speiseplan erstellen
    public void erstelleSpeiseplan()
    {
        erstelleMenuFuerWochentag("Montag", 4);
        erstelleMenuFuerWochentag("Dienstag", 4);
        erstelleMenuFuerWochentag("Mittwoch", 5);
    }

    public String getMenueFuerWochentag(String tag)
    {
        StringBuilder result = new StringBuilder();
        result.append(tag).append(":\n");

        if (speiseplan.containsKey(tag))
        {
            // Tagesspeiseplan holen aus der Map 'speiseplan' und sortieren
            // sortierung mit 'Comparable'
            List<Gericht> aktuellerSpeiseplan = speiseplan.get(tag);
            Collections.sort(aktuellerSpeiseplan);

            // Alternative
            // aktuellerSpeiseplan.sort(Gericht::compareTo);

            for (Gericht tagesGericht: aktuellerSpeiseplan) {
                result.append(tagesGericht.toString());
            }

        } else {
            result.append("Die Mensa hat geschlossen!");
        }

        result.append("\n");
        return result.toString();
    }

}
