package oop_vignere_chiffre;

import java.util.ArrayList;

/**
 * Holds the functions needed to enocde a given input text with the vigener method and also
 * functions to decode an encoded text.
 */
public class Cipher {

    private String inputText;
    private ArrayList<String> cipherTable;
    private String keyword;
    private String cipheredText;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    /**
     * Constructor for the Cipher class with a given keyword. The
     * lookup table will be generated intern based on this keyword.
     * @param keyword   Used keyword to generate table.
     */
    public  Cipher (String keyword) {
        this.keyword = keyword.toLowerCase().replaceAll("\\s+", "");
        this.cipherTable = CipherTable.generateCipherTable(keyword);
    }

    /**
     * Helper function to keep the punctuation and the whitescpaces of the encoded text the same
     * as in the original input text. In this way only letters will be encoded.
     * @param inputChar punctuation mark to keep
     * @return true if punctuation mark is of type "."; ","; "!"; "?"; ";" or a whitespace
     */
    public boolean keepPunctuation(char inputChar){
        if (Character.compare(inputChar,' ') == 0 ){
            return true;
        } else if (Character.compare(inputChar,'.') == 0){
            return true;
        } else if (Character.compare(inputChar,',') == 0) {
            return true;
        }else if (Character.compare(inputChar,'!') == 0) {
            return true;
        }else if (Character.compare(inputChar,'?') == 0) {
            return true;
        }else {
            return Character.compare(inputChar, ';') == 0;
        }
    }

    /**
     * Function to cipher a given input text from a file and write it to an output file.
     * @param inputFile file to encode
     * @param outputFile encoded file
     * @param print if true, input and output file will also be written on the console
     */
    public void runCipher(String inputFile, String outputFile, boolean print){

        IOFiles ioF = new IOFiles();
        inputText = ioF.readFile(inputFile);
        this.inputText = inputText.toLowerCase().replaceAll("\\s", " ");

        if(print) {
            System.out.println("the inputText is: ");
            System.out.println(inputText+"\n");
        }

        StringBuilder cipheredTextSB = new StringBuilder();

        cipherTable = CipherTable.generateCipherTable(keyword);

        for (int inputIndex = 0, keyWordIndex = 0;
             inputIndex < inputText.length();
             inputIndex++, keyWordIndex++) {

            char inputLetter =  inputText.charAt(inputIndex);
            if (keepPunctuation(inputLetter)){
                cipheredTextSB.append(inputLetter);
                keyWordIndex--;
                continue;
            };
            int alphabetIndex = alphabet.indexOf(inputLetter);

            String cipherRow;

            if (keyWordIndex > keyword.length()-1){
                keyWordIndex = 0;
                cipherRow = cipherTable.get(keyWordIndex);
            } else {
                cipherRow = cipherTable.get(keyWordIndex);
            }
            char cipherLetter = cipherRow.charAt(alphabetIndex);

            cipheredTextSB.append(cipherLetter);
        }
        cipheredText = cipheredTextSB.toString();

        ioF.writeFile(outputFile, cipheredText );
        if (print){
            System.out.println("the cipheredText is :");
            System.out.println(cipheredText+"\n");}
    }

    /**
     * Read the cipher text from a specified input file and write the
     * deciphered text to an output file (plus output to the console)
     * @param inputFile     Name of the given cipher text.
     * @param outputFile    Name of the new output file.
     */
    public void decipherText(String inputFile, String outputFile, boolean print) {
        IOFiles ioF = new IOFiles();
        String fileContent = ioF.readFile(inputFile);

        StringBuilder decipheredText = new StringBuilder();
        char alphabetLetter;
        int cipherLetterIndex;
        String cipherLine;
        for (int i = 0, j = 0; i < fileContent.length(); i++, j++) {
            if (Character.isLetter(fileContent.charAt(i))) {
                // actual cipher table line and index of actual text letter
                cipherLine = this.cipherTable.get(j % this.keyword.length());
                cipherLetterIndex = cipherLine.indexOf(fileContent.charAt(i));

                // reverse alphabet letter based on cipher letter index in line
                alphabetLetter = this.alphabet.charAt(cipherLetterIndex);
            } else {
                alphabetLetter = fileContent.charAt(i);
                j--;
            }
            decipheredText.append(alphabetLetter);
        }

        if (print){
            System.out.println("the decipheredText is: ");
            System.out.println(decipheredText);
        }

        ioF.writeFile(outputFile, decipheredText.toString());
    }
}

