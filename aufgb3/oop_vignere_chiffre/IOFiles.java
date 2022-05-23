package oop_vignere_chiffre;
import oop_vignere_chiffre.Exceptions.WrongCharacterException;
import oop_vignere_chiffre.Exceptions.WrongDatatypeException;

import java.io.File;

public class IOFiles {

    /**
     * Check given filename if it is .txt file
     * @param filename  Given filename
     * @throws WrongDatatypeException
     */
    private void checkFiletype (String filename)
        throws WrongDatatypeException
    {
        if (!filename.toLowerCase().endsWith(".txt")){
            throw new WrongDatatypeException(filename);
        }
    }

    /**
     * Read the given filename and return string as content.
     * @param filename
     * @return content  String of
     * @throws WrongDatatypeException
     * @throws WrongCharacterException
     */
    public static String readFile (String filename)
        throws WrongDatatypeException, WrongCharacterException
    {
        File inputFile = new File(filename);
        int currentLine = 1;
        return "";
    }

}
