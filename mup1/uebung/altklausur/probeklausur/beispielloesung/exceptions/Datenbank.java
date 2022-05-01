package exceptions;

public class Datenbank
{
    // Frage 16:
    public void ausfuehren(String befehl) throws DatenbankException
    {
        if (befehl.equals("")) {
            throw new DatenbankException();

        }
        // weiterer Code, welcher den gewünschten Befehl ausführt<br>
    }

    public void schliessen()
    {
    }


    // Frage 17:
    public void ausfuehrenUndSchliessen(String befehl)
    {
        try
        {
            ausfuehren(befehl);
        }
        catch (DatenbankException e)
        {
            return;
        }
        finally
        {
            schliessen();
        }
    }
}