package vererbung;

public class Medium
{
    private int mediennummer;
    private String titel;

    public Medium(int mediennummer, String titel)
    {
        this.mediennummer = mediennummer;
        this.titel = titel;
    }


    public String toString()
    {
        return String.format("Mediennummer: %d, Titel: %s", mediennummer, titel);
    }

    public int getMediennummer()
    {
        return mediennummer;
    }


    public String getTitel()
    {
        return titel;
    }
}
