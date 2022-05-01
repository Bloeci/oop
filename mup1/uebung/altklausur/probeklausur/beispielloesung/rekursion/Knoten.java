package rekursion;

import java.util.ArrayList;
import java.util.List;

public class Knoten{
    private List<Knoten> kinder;
    private int wert;

    public Knoten()
    {
        this.kinder = new ArrayList<Knoten>();
        this.wert = 0;
    }

    public Knoten(List<Knoten> kinder, int wert)
    {
        this.kinder = new ArrayList<Knoten>(kinder);
        this.wert = wert;
    }

    public List<Knoten> getKinder()
    {
        return kinder;
    }

    public int getAnzahlKinder()
    {
        return kinder.size();
    }

    public Knoten getKnoten(int index)
    {
        if(index < kinder.size())
        {
            return kinder.get(index);
        }
        else
        {
            return null;
        }
    }

    public int getWert()
    {
        return wert;
    }

    // Frage 12:
    public int getMaxWertVonBaum( )
    {
        int maximum = wert;
        for (Knoten kind: kinder)
        {
            int maximumKind = kind.getMaxWertVonBaum();
            if (maximumKind > maximum)
            {
                maximum = maximumKind;
            }
        }
        return maximum;
    }
}

