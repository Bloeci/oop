public class RegelmaessigesNEck implements GeometrischeForm
{
    private int ecken;
    private double umkreisradius;

    public RegelmaessigesNEck(int ecken, double umkreisradius)
    {
        this.ecken = ecken;
        this.umkreisradius = umkreisradius;
    }

    @Override
    public int anzahlEcken()
    {
        return ecken;
    }

    @Override
    public double berechneFlaeche()
    {
        return ecken * umkreisradius * umkreisradius * Math.sin(2 * MEIN_PI / ecken) / 2;
    }

    @Override
    public double berechneUmfang()
    {
        return ecken * 2 * umkreisradius * Math.sin(MEIN_PI / ecken);
    }
}
