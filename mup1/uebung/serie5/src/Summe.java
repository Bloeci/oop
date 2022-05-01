import Interfaces.Operator;

public class Summe implements Operator{

    private double summe;

    public Summe() {
        this.summe = 0;
    }

    @Override
    public void verarbeiteWert(double wert) {
        summe += wert;
    }

    @Override
    public double liefereErgebnis() {
        return summe;
    }

    @Override
    public String getBezeichnung() {
        return "Berechnung der Summe";
    }
}
