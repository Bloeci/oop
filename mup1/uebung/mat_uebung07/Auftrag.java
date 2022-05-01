public class Auftrag implements Comparable<Auftrag>
{
    private String produktbezeichnung;
    private int wichtigkeit;
    private int restdauer;

    public Auftrag(String produktbezeichnung, int wichtigkeit, int restdauer)
    {
        this.produktbezeichnung = produktbezeichnung;
        if (wichtigkeit < 0)
        {
            wichtigkeit = 0;
        }
        if (wichtigkeit > 3)
        {
            wichtigkeit = 3;
        }
        this.wichtigkeit = wichtigkeit;
        if (restdauer < 1)
        {
            restdauer = 1;
        }
        this.restdauer = restdauer;
    }


    public boolean istErledigt()
    {
        return restdauer == 0;
    }


    public int compareTo(Auftrag query)
    {
        if (query.wichtigkeit == this.wichtigkeit)
        {
            return query.restdauer - this.restdauer;
        }
        return query.wichtigkeit - this.wichtigkeit;
    }


    public String toString()
    {
        return String.format("Produkt: %-20s, Wichtigkeit: %d, Tage verbleibend: %3d", produktbezeichnung, wichtigkeit, restdauer);
    }


    public String getProduktbezeichnung()
    {
        return produktbezeichnung;
    }


    public int getRestdauer()
    {
        return restdauer;
    }


    public void setRestdauer(int restdauer)
    {
        this.restdauer = restdauer;
    }
}
