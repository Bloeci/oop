public class Film
{
    private String titel;
    private String inhalt;

    public Film(String titel, String inhalt)
    {
        this.titel = titel;
        this.inhalt = inhalt;
    }


    public String getTitel()
    {
        return titel;
    }


    public void wiedergabe()
    {
        System.out.println(titel + "\n");
        System.out.println(inhalt + "\n");
    }


    public boolean equals(Object obj)
    {
        if (!(obj instanceof Film))
        {
            return false;
        }
        return ((Film)obj).titel.equals(this.titel);
    }

}
