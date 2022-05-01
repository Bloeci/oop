public class Episode extends Film
{
    private String serie;
    private int episodennummer;
    private Episode naechste;
    private Episode vorherige;

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

    public String getSerie()
    {
        return serie;
    }

    public Episode getNaechste()
    {
        return naechste;
    }

    public void setNaechste(Episode naechste)
    {
        this.naechste = naechste;
        /*
        Damit bei der naechsten Episode nicht separat setVorherige aufgerufen werden muss (die vorherige
        Episode von naechste ist ja this), erfolgt der Aufruf gleich hier.
        Wichtig: in setVorherige darf NICHT setNaechste aufgerufen werden, soll würde sich eine
        Endlosschleife von Methodenaufrufen ergeben.
         */
        naechste.setVorherige(this);
    }

    public Episode getVorherige()
    {
        return vorherige;
    }

    public void setVorherige(Episode vorherige)
    {
        this.vorherige = vorherige;
    }
}
