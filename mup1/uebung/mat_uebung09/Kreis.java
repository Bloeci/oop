public class Kreis implements GeometrischeForm
{
    private double radius;

    public Kreis(double radius)
    {
        this.radius = radius;
    }


    @Override
    public int anzahlEcken()
    {
        return 0;
    }


    @Override
    public double berechneFlaeche()
    {
        return MEIN_PI * radius * radius;
    }

    @Override
    public double berechneUmfang()
    {
        return 2 * MEIN_PI * radius;
    }
}
