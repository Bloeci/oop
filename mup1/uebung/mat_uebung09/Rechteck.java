public class Rechteck implements GeometrischeForm
{
    private double breite;
    private double hoehe;

    public Rechteck(double breite, double hoehe)
    {
        this.breite = breite;
        this.hoehe = hoehe;
    }


    @Override
    public int anzahlEcken()
    {
        return 4;
    }


    @Override
    public double berechneFlaeche()
    {
        return breite * hoehe;
    }


    @Override
    public double berechneUmfang()
    {
        return 2 * breite + 2 * hoehe;
    }
}
