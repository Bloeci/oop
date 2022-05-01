package exceptions;

/*
Die Klasse NumberException soll von Exception erben.

Dem Konstruktor soll eine Fehlermeldung übergeben werden können.
 */
public class NumberException extends Exception
{
    public NumberException(String nachricht)
    {
        super(nachricht);
    }
}
