import Interfaces.Operator;

public class Durchschnitt implements Operator{

    private int anzahlSummanden;
    private double summe;

    public Durchschnitt () {
        this.anzahlSummanden = 0;
        this.summe = 0;
    }

    @Override
    public void verarbeiteWert(double wert) {
        summe += wert;
        anzahlSummanden += 1;
    }

    @Override
    public double liefereErgebnis() {
        return summe/anzahlSummanden;
    }


    @Override
    public String getBezeichnung() {
        return "Berechnung des Durchschnitts";
    }
}
