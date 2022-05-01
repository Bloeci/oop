import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Schokoladenfabrik
{
    private Auftragsbuch auftragsbuch;
    private Map<String, Auftrag> auftragsverteilung = new TreeMap<>();
    private Map<String, Integer> anzahlFertigerProdukte = new HashMap<>();
    private Datum datum;

    public Schokoladenfabrik(Auftragsbuch auftragsbuch, String[] alleMitarbeiter, Datum datum)
    {
        this.auftragsbuch = auftragsbuch;
        for (String einMitarbeiter: alleMitarbeiter)
        {
            auftragsverteilung.put(einMitarbeiter, null);
        }
        this.datum = datum;
    }


    public void simulieren()
    {
        while (!datum.istWeihnachten())
        {
            System.out.println("\n" + datum);
            // Für jeden Mitarbeiter...
            for (String mitarbeiter: auftragsverteilung.keySet())
            {
                // ... wird zuerst überprüft, ob er momentan keine Aufgabe hat. Ist dies der Fall, wird im ein
                // Auftrag zugewiesen. Dieser Auftrag kann auch null sein, wenn das Auftragsbuch leer ist.
                if (auftragsverteilung.get(mitarbeiter) == null)
                {
                    auftragsverteilung.put(mitarbeiter, auftragsbuch.naechsterAuftrag());
                }
                // Wenn ein Mitarbeiter eine Aufgabe hat, wird die verbliebene Zeitdauer für den Auftrag um
                // einen Tag reduziert.
                Auftrag auftragDesMitarbeiters = auftragsverteilung.get(mitarbeiter);
                if (auftragDesMitarbeiters != null)
                {
                    auftragDesMitarbeiters.setRestdauer(auftragDesMitarbeiters.getRestdauer() - 1);
                    // Wenn der Auftrag erledigt ist, wird die Aufgabe des Mitarbeiters auf null gesetzt und
                    // der Zähler für fertiggestellte Produkte um eins erhöht
                    if (auftragDesMitarbeiters.istErledigt())
                    {
                        System.out.println(String.format("%s wurde von %s fertiggestellt", auftragDesMitarbeiters.getProduktbezeichnung(), mitarbeiter));
                        auftragsverteilung.put(mitarbeiter, auftragsbuch.naechsterAuftrag());
                        erhoeheProduktZaehler(auftragDesMitarbeiters.getProduktbezeichnung());
                    }
                }
            }
            aufgabenverteilungAusgeben();
            anzahlFertigerProdukteAusgaben();
            datum.naechsterTag();
        }
    }


    private void erhoeheProduktZaehler(String produktname)
    {
        if (anzahlFertigerProdukte.containsKey(produktname))
        {
            anzahlFertigerProdukte.put(produktname, anzahlFertigerProdukte.get(produktname) + 1);
        }
        else
        {
            anzahlFertigerProdukte.put(produktname, 1);
        }
    }


    private void aufgabenverteilungAusgeben()
    {
        System.out.println("\nAufgabenverteilung am Ende des Tages:");
        for (String mitarbeiter: auftragsverteilung.keySet())
        {
            System.out.println(String.format("%s: %s", mitarbeiter, auftragsverteilung.get(mitarbeiter)));
        }
    }

    private void anzahlFertigerProdukteAusgaben()
    {
        System.out.println("\nFertiggestellte Produkte:");
        for (Map.Entry<String, Integer> eintrag: anzahlFertigerProdukte.entrySet())
        {
            System.out.println(String.format("%s: %s", eintrag.getKey(), eintrag.getValue()));
        }
    }
}
