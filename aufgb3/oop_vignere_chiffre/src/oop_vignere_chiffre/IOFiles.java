package oop_vignere_chiffre;
import oop_vignere_chiffre.Exceptions.WrongCharacterException;
import oop_vignere_chiffre.Exceptions.WrongDatatypeException;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.StandardCharsets;

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
     * Replace german 'Umlaute' with corresponding letters. For
     * example "ä" -> "ae".
     * @param nc    String (character)
     * @return nc   replaced String if contain german special letter
     */
    private String replaceGermanCharacter (String nc){
        nc = switch (nc) {
            case "ä" -> "ae";
            case "ö" -> "oe";
            case "ü" -> "ue";
            case "ß" -> "ss";
            default -> nc;
        };
        return nc;
    }

    /**
     * Process given character by checking if char is letter, defined or german
     * special character ('Umlaute'). Returns the character as String if valid or
     * threw an exception.
     * @param character
     * @return newCharacter     Processed character as string (bc. "ä" -> "ae")
     * @throws WrongCharacterException  Character if not defined
     */

    private String processCharacter (char character)
            throws WrongCharacterException
    {
        String nc = "";
        if (Character.isLetter(character)){
            nc = String.valueOf(Character.toLowerCase(character));
            nc = replaceGermanCharacter(nc);
        } else {
            if (!Character.isDefined(character)){
                throw new WrongCharacterException();
            }
            nc = String.valueOf(character);
        }

        return nc;
    }

    /**
     * Validate a given string line. Check for all character, if they can
     * process to a std charset.
     * @param line  Line from file
     */
    private String processLine (String line)
            throws WrongCharacterException
    {
        char currentChar;
        StringBuilder lineContent = new StringBuilder();
        for (int i = 0; i < line.length(); i++){
            currentChar = line.charAt(i);
            lineContent.append(processCharacter(currentChar));
        }
        return lineContent.toString();
    }

    /**
     * Read the given filename and return string as content.
     * @param filename
     * @return content  String of
     * @throws WrongDatatypeException
     * @throws WrongCharacterException
     */
    public String readFile (String filename)
        throws WrongDatatypeException, WrongCharacterException
    {
        File inputFile = new File(filename);
        int currentLine = 1;
        StringBuilder content = new StringBuilder();
        try {
            checkFiletype(filename);
            FileReader fileReader = new FileReader(inputFile, StandardCharsets.ISO_8859_1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // read lines
            String line;
            while ((line = bufferedReader.readLine()) != null){
                line = processLine(line);
                content.append(line).append(' ');
                currentLine++;
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException fnf) {
            System.err.println("[ERROR] File '" + filename + "' not found. Exit.");
            fnf.printStackTrace();
            System.exit(1);

        } catch (IOException ioex) {
            System.err.println("[ERROR] Something happened during Input/Output. Exit.");
            ioex.printStackTrace();
            System.exit(1);

        } catch (WrongCharacterException wc) {
            throw new WrongCharacterException(filename, currentLine);
        }

        return content.toString();
    }

    /**
     * Read the given filename and return string as content.
     * @param filename  Target filename which would be written.
     * @param content   Given content for the file as string.
     */
    public void writeFile (String filename, String content) {
        // Create output directory, if not exist
        // File directory = new File(System.getProperty("user.dir") + "/ausgabe");
        // if (!directory.exists()) { directory.mkdir();}

        // Create File and write output (try-Block)
        File newFile = new File(filename);
        try {
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(content);

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioex) {
            System.err.println("[ERROR] Something happened during Input/Output. Exit.");
            ioex.printStackTrace();
            System.exit(1);
        }
    }
}
