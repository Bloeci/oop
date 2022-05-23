package oop_vignere_chiffre;
import java.util.ArrayList;

public class DeCipher {
    private ArrayList<String> cipherTable;
    private String keyword;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    /**
     * Constructor for the decipher class with a given keyword. The
     * lookup table will be generated intern based on this keyword.
     * @param keyword   Used keyword to generate table.
     */
    public DeCipher (String keyword) {
        this.cipherTable = new CipherTable().generateCipherTable(keyword);
        this.keyword = keyword;
    }

    /**
     * Getter for the actual keyword string.
     * @return keyword
     */
    public String getKeyword(){
        return this.keyword;
    }

    /**
     * Getter for the actual cipher lookup table.
     * @return  cipherTable
     */
    public ArrayList<String> getCipherTable(){
        return this.cipherTable;
    }


    public void decipherText(String inputFile, String outputFile){
        StringBuilder decipheredText = new StringBuilder();

        char alphabetLetter;
        int cipherLetterIndex;
        String cipherLine;
        for (int i = 0; i < inputFile.length(); i++) {
            if (Character.isLetter(inputFile.charAt(i))) {
                // actual cipher table line and index of actual text letter
                cipherLine = this.cipherTable.get(i % this.keyword.length());
                cipherLetterIndex = cipherLine.indexOf(inputFile.charAt(i));

                // reverse alphabet letter based on cipher letter index in line
                alphabetLetter = this.alphabet.charAt(cipherLetterIndex);
            } else {
                alphabetLetter = inputFile.charAt(i);
            }
            decipheredText.append(alphabetLetter);
        }

        System.out.println(decipheredText);
    }
}
