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


    public void streameFilm(String titel)
    {
        Film gesuchterFilm = findeFilm(titel);
        if (gesuchterFilm != null)
        {
            gesuchterFilm.wiedergabe();
        }
        else
        {
            System.out.printf("Der gesuchte Film %s existiert nicht!%n", titel);
        }
    }
}
