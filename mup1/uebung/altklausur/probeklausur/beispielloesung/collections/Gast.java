package collections;

public class Gast implements Comparable<Gast>
{
    private String name;
    private String status;
    private int besuche;

    public Gast(String name, String status, int besuche)
    {
        this.name = name;
        this.status = status;
        this.besuche = besuche;
    }

    public String getName()
    {
        return name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getBesuche()
    {
        return besuche;
    }

    public int compareTo(Gast o)
    {
        return name.compareTo(o.name);
    }
}
