import java.util.Random;

public class StreamingDienst
{
    private Film[] filme;

    public StreamingDienst()
    {
        filme = new Film[100];
    }


    public void addFilm(Film neuerFilm)
    {
        for (int k = 0; k < filme.length; k++)
        {
            if (filme[k] == null)
            {
                filme[k] = neuerFilm;
                break;
            }
        }
    }


    public Film findeFilm(String titel)
    {
        for (int k = 0; k < filme.length; k++)
        {
            if (filme[k] == null)
            {
                continue;
            }
            if (filme[k].getTitel().equals(titel))
            {
                return filme[k];
            }
        }
        return null;
    }


    public void streameFilm(Film film, Nutzer nutzer)
    {
        nutzer.kaufeFilm(film);
        film.wiedergabe();
    }


    public void streameFilm(String titel, Nutzer nutzer)
    {
        Film gesuchterFilm = findeFilm(titel);
        if (gesuchterFilm != null)
        {
            streameFilm(gesuchterFilm, nutzer);
        }
        else
        {
            System.out.printf("Der gesuchte Film %s existiert nicht!%n", titel);
        }
    }


    private Episode findeErsteEpisode(String serienname)
    {
        for (Film film: filme)
        {
            if (film instanceof Episode && ((Episode) film).getSerie().equals(serienname) && ((Episode) film).getVorherige() == null)
            {
                return (Episode)film;
            }
        }
        return null;
    }


    public void streameSerie(String serienname, Nutzer nutzer)
    {
        Episode episode = findeErsteEpisode(serienname);
        if (episode == null)
        {
            System.out.println("Die Serie konnte nicht gefunden werden.");
            return;
        }
        streameFilm(episode, nutzer);
        while (episode.getNaechste() != null)
        {
            episode = episode.getNaechste();
            streameFilm(episode, nutzer);
        }
    }

    public void streameZufallsfilm(Nutzer nutzer)
    {
        Random random = new Random();
        int zufallszahl;
        while (true)
        {
            zufallszahl = random.nextInt(filme.length);
            if (filme[zufallszahl] != null)
            {
                streameFilm(filme[zufallszahl], nutzer);
                break;
            }
        }
    }
}
