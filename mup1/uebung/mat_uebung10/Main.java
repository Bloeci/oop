import collections.Tier;
import collections.Zoo;
import exceptions.Rechentester;
import rekursion.PseudocodeUebung;
import strings.StringUebung;
import vererbung.*;

import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void collectionsUebung()
    {
        System.out.println("\n\nÜbung Collections:");
        Zoo zoo = new Zoo();
        zoo.addTier(new Tier("Jack", "Giraffe", 1312));
        zoo.addTier(new Tier("Muffin", "Giraffe", 71));
        zoo.addTier(new Tier("Jira", "Giraffe", 71));
        zoo.addTier(new Tier("Simba", "Löwe", 4652));
        zoo.addTier(new Tier("Simba II.", "Löwe", 81));
        zoo.addTier(new Tier("Leo", "Löwe", 3923));
        zoo.addTier(new Tier("Savannah", "Löwe", 3491));
        zoo.addTier(new Tier("Erdi", "Erdmännchen", 199));
        zoo.addTier(new Tier("Erda", "Erdmännchen", 176));
        zoo.addTier(new Tier("Mira", "Erdmännchen", 31));
        System.out.println("Tierbabies:");
        for (Tier tier: zoo.getTierbabies())
        {
            System.out.println(tier);
        }
        System.out.println("\nArtenzähler:");
        System.out.println(zoo.artenzaehlerToString());
        zoo.ausgabeTiere();

    }
    public static void pseudocodeUebung()
    {
        System.out.println("\n\nÜbung Pseudocode:");
        int[] arr = {14,12,0,-3,129,-213,399,3,32,-81};
        System.out.println("Maximum: " + PseudocodeUebung.maximum(arr));
    }


    public static void exceptionUebung()
    {
        System.out.println("\n\nÜbung Exceptions");
        Rechentester.teste(3,1.1);
        Rechentester.teste(3,1);
        Rechentester.teste(-3,1.1);
    }


    public static void vererbungUebung()
    {
        System.out.println("\n\nÜbung Vererbung:");
        List<Medium> medien = new ArrayList<>();
        medien.add(new Buch(12312, "Ein Buch", 746, "Ein Autor"));
        medien.add(new Buch(93214, "Noch ein Buch", 428, "Ein Autor"));
        medien.add(new Film(12901, "Der Ring der Herren 1", 143.2, "Jack Peterson"));
        medien.add(new Film(12902, "Der Ring der Herren 2", 189.19, "Jack Peterson"));
        medien.add(new Album(292311, "Ganz ganz laute Musik", 74.5, "Die Krachmacher"));
        Sammlung sammlung = new Sammlung(medien);
        System.out.println("Gesamtdauer: " + sammlung.berechneGesamtlaufzeit());
    }

    public static void stringUebungen()
    {
        System.out.println("\n\nstringUebung1:");
        StringUebung.stringUebung1();
        System.out.println("\n\nstringUebung2:");
        StringUebung.stringUebung2();
        System.out.println("\n\nstringUebung3:");
        StringUebung.stringUebung3();
        System.out.println("\n\nstringUebung4:");
        StringUebung.stringUebung4();
        System.out.println("\n\nstringUebung5:");
        StringUebung.stringUebung5();
        System.out.println("\n\nstringUebung6:");
        StringUebung.stringUebung6();
        System.out.println("\n\nstringUebung7:");
        System.out.println(StringUebung.stringUebung7("Datei.txt", ".txt"));
        System.out.println(StringUebung.stringUebung7("Datei.pdf", ".txt"));
    }


    public static void main(String[] args)
    {
        //collectionsUebung();
        //pseudocodeUebung();
        //exceptionUebung();
        //vererbungUebung();
        //stringUebungen();
    }
}
