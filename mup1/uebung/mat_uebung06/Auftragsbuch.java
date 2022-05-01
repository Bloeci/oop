import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auftragsbuch
{
    private List<Auftrag> auftraege;

    public Auftragsbuch()
    {
        auftraege = new ArrayList<>();
    }


    public void auftragHinzufuegen(Auftrag auftrag)
    {
        auftraege.add(auftrag);
        Collections.sort(auftraege);
    }


    public Auftrag naechsterAuftrag()
    {
        if (auftraege.isEmpty())
        {
            return null;
        }
        return auftraege.remove(0);
    }


    public void ausgeben()
    {
        for (Auftrag auftrag: auftraege)
        {
            System.out.println(auftrag);
        }
    }
}
