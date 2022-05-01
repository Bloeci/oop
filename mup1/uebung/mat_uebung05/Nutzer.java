public class Nutzer
{
    private Film[] gekaufteFilme;

    public Nutzer()
    {
        gekaufteFilme = new Film[100];
    }


    public boolean besitztFilm(Film film)
    {
        for (int k = 0; k < gekaufteFilme.length; k++)
        {
            if (gekaufteFilme[k] == film)
            {
                return true;
            }
        }
        /*
        for (Film wert : gekaufteFilme)
        {
            if (wert == film)
            {
                return true;
            }
        }*/
        return false;
    }

    public void kaufeFilm(Film film)
    {
        if (besitztFilm(film))
        {
            return;
        }
        for (int k = 0; k < gekaufteFilme.length; k++)
        {
            if (gekaufteFilme[k] == null)
            {
                gekaufteFilme[k] = film;
            }
        }
    }

    
}
