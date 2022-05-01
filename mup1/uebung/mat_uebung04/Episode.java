public class Episode extends Film
{
    private String serie;
    private int episodennummer;

    public Episode(String titel, String inhalt, String serie, int episodennummer)
    {
        super(titel, inhalt);
        this.serie = serie;
        this.episodennummer = episodennummer;
    }


    public void wiedergabe()
    {
        System.out.println(serie + " - Folge " + episodennummer);
        super.wiedergabe();
    }
}
