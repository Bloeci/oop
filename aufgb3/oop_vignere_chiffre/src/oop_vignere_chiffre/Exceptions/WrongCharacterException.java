package oop_vignere_chiffre.Exceptions;

public class WrongCharacterException extends Exception {
    public WrongCharacterException () {
        super("[Warning] Non valid character.");
    }

    public WrongCharacterException (String filename, int linenumber) {
        super("[Warning] Non valid character in '" + filename + "' - Line " + linenumber);
    }
}
