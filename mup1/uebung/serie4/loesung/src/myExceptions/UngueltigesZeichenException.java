package myExceptions;

public class UngueltigesZeichenException extends Exception{

    // Standard Constructor
    public UngueltigesZeichenException()
    {
        super("[Warnung] Ungueltiges Zeichen");
    }

    // Constructor with parameters
    public UngueltigesZeichenException(String dateiname, int zeilennummer)
    {
        super("[Warnung] Ungueltiges Zeichen in '" + dateiname + "' - Zeile " + zeilennummer);
    }

}