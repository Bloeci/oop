package exceptions;
/*
Die Methode log(zahl, basis) der Klasse Rechner soll
- falls zahl negativ oder 0 ist eine NumberException mit der entsprechenden Fehlermeldung
- falls basis negativ, 0 oder 1 ist eine BaseException mit der entsprechenden Fehlermeldung
werfen. Die Ausnahmen sollen nicht weiter behandelt werden.
 */
public class Rechner
{
    public static double log(double zahl, double basis) throws BaseException, NumberException
    {
        if (zahl <= 0)
        {
            throw new NumberException("Eine negative Zahl kann nicht logarithmiert werden.");
        }
        if (basis <= 0.0 || basis == 1.0)
        {
            throw new BaseException("Die Basis darf weder negativ noch gleich 1 sein.");
        }
        return Math.log(zahl) / Math.log(basis);
    }
}
