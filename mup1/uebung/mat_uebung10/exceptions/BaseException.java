package exceptions;

/*
Die Klasse BaseException soll von NumberException erben.

Dem Konstruktor soll eine Fehlermeldung übergeben werden können.
 */
public class BaseException extends NumberException
{
    public BaseException(String nachricht)
    {
        super(nachricht);
    }
}
