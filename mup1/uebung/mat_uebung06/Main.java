import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Auftragsbuch auftraege = new Auftragsbuch();
        auftraege.auftragHinzufuegen(new Auftrag("Lebkuchen", 2, 5));
        auftraege.auftragHinzufuegen(new Auftrag("Schokoladentafel", 3, 6));
        auftraege.auftragHinzufuegen(new Auftrag("Lakritzschnecke", 1, 6));
        auftraege.auftragHinzufuegen(new Auftrag("Lebkuchen", 2, 3));
        auftraege.auftragHinzufuegen(new Auftrag("Lebkuchen", 1, 7));
        auftraege.auftragHinzufuegen(new Auftrag("Lebkuchen", 1, 1));
        auftraege.auftragHinzufuegen(new Auftrag("Bonbons", 1, 4));
        auftraege.auftragHinzufuegen(new Auftrag("Pralinen", 3, 2));
        auftraege.auftragHinzufuegen(new Auftrag("Pralinen", 1, 7));
        auftraege.auftragHinzufuegen(new Auftrag("Oblaten", 2, 3));
        auftraege.auftragHinzufuegen(new Auftrag("Schokoladentafel", 2, 6));
        auftraege.auftragHinzufuegen(new Auftrag("Lakritzschnecke", 2, 3));
        auftraege.auftragHinzufuegen(new Auftrag("Oblaten", 3, 4));
        auftraege.auftragHinzufuegen(new Auftrag("Pralinen", 3, 5));
        auftraege.auftragHinzufuegen(new Auftrag("Bonbons", 3, 5));
        auftraege.auftragHinzufuegen(new Auftrag("Schokoladenweihnachtsmann", 1, 2));

        System.out.println("Alle Aufträge im Auftragsbuch:");
        auftraege.ausgeben();

        String[] mitarbeiter = {"Rudolp", "Trixi", "Santa"};

        Datum datum = new Datum(2019, 12, 1);

        Schokoladenfabrik fabrik = new Schokoladenfabrik(auftraege, mitarbeiter, datum);
        fabrik.simulieren();
    }
}
