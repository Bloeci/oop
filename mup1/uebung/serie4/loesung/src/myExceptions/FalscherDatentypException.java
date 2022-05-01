package myExceptions;

public class FalscherDatentypException extends Exception {

    public FalscherDatentypException (String dateiname)
    {
        super("[Warnung] '" + dateiname + "' hat eine nicht kompatible Dateiendung.");
    }

}
