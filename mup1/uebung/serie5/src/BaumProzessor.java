import Interfaces.Operator;
import java.util.*;

import java.util.ArrayList;

public class BaumProzessor{
    private Knoten wurzelDesBaumes;
    private Operator operator;

    public BaumProzessor (Knoten wurzelDesBaumes, Operator operator)
    {
        this.wurzelDesBaumes = wurzelDesBaumes;
        this.operator = operator;
    }

    //
    public void berechneErgebnis()
    {
        verarbeiteKnoten(this.wurzelDesBaumes);
        System.out.printf("Durchgefuehrte Operation: %s%n", operator.getBezeichnung());
        System.out.printf("Ergebnis: %s%n", operator.liefereErgebnis());
        System.out.println("-------");

    }

    //
    public void verarbeiteKnoten(Knoten knoten)
    {
        List<Knoten> kinder = new ArrayList<>(knoten.getKinder());
        operator.verarbeiteWert(knoten.getWert());
        for (Knoten kind: kinder) {
            if (kind != null) {
                verarbeiteKnoten(kind);
            }
        }
    }

}
