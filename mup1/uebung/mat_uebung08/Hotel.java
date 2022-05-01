import java.util.ArrayList;
import java.util.List;

public class Hotel
{
    private int ID;
    List<Bewertung> bewertungen = new ArrayList<>();

    public Hotel(int ID) {
        this.ID = ID;
    }

    public void bewertungHinzufuegen(Bewertung bewertung) {
        bewertungen.add(bewertung);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("ID: ");
        sb.append(ID);
        sb.append("\n");
        sb.append("Bewertungen:\n");
        for (Bewertung bewertung: bewertungen) {
            sb.append(bewertung);
            sb.append("\n");
        }
        return sb.toString();
    }
}
