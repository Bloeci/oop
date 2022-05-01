package collections;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Hotel {
    private Map<Gast, Integer> belegung;
    private List<Gast> bisherigeGaeste;

    public Hotel() {
        belegung = new TreeMap<Gast, Integer>();
        bisherigeGaeste = new ArrayList<Gast>();
    }

    // Frage 6:
    public List<Gast> neueStammgaeste(int mindestBesuche) {
        List<Gast> ret = new ArrayList<>();
        for (Gast gast: bisherigeGaeste)
        {
            if (gast.getStatus().equals("Regulärer Gast") && gast.getBesuche() >= mindestBesuche) {
                gast.setStatus("Stammgast");
                ret.add(gast);
            }
        }
        return ret;
    }

    // Frage 7:
    public int gaesteStatistik() {
        return bisherigeGaeste.size();
    }

    // Frage 8:
    public void zimmerZuweisen(Gast gast, Integer zimmer) {
        if (belegung.containsKey(gast))
        {
            return;
        }
        belegung.put(gast, zimmer);
    }

    // Frage 9:
    public void checkOut(Gast gast)
    {
        belegung.remove(gast);
    }

}