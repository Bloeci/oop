package oop_vignere_chiffre.Exceptions;

public class WrongDatatypeException extends Exception {
    public WrongDatatypeException (String filename)
    {
        super("[Warning] '" + filename + "' dont have a valid file ending.");
    }
}
