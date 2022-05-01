public class Datum
{
    private int jahr;
    private int monat;
    private int tag;

    public Datum(int jahr, int monat, int tag)
    {
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
    }


    public boolean istWeihnachten()
    {
        return monat == 12 && tag == 24;
    }


    public void naechsterTag()
    {
        if ((tag == 31 && (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12)) ||
                (tag == 28 && monat == 2) ||
                ((tag == 30) && (monat == 4 || monat == 6 || monat == 9 || monat == 11)))
        {
            tag = 1;
            monat++;
        }
        else
        {
            tag++;
        }
        if (monat == 13)
        {
            monat = 1;
            jahr++;
        }
    }


    public String toString()
    {
        return String.format("%d.%d.%d", tag, monat, jahr);
    }
}
