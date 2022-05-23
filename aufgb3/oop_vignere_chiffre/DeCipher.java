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
        this.cipherTable = generateCipherTable(keyword);
        this.keyword = keyword;
    }

    /**
     * Generate a cipher table based on a given keyword length n.
     * @param keyword   String to decipher a given text.
     * @return cipher  Lookup table with size n.
     */
    private ArrayList<String> generateCipherTable(String keyword) {
        ArrayList<String> cipher = new ArrayList<>(keyword.length());

        int alphabetLetterIndex, cipherIndex;
        char keywordLetter;
        for (int i = 0; i < keyword.length(); i++) {
            // get actual letter in keyword and index in alphabet
            keywordLetter = keyword.charAt(i);
            alphabetLetterIndex = this.alphabet.indexOf(keywordLetter);

            StringBuilder cipherLine = new StringBuilder();
            // iterate throw alphabet with modulo index
            for (int j = 0; j < 26; j++) {
                cipherIndex = (alphabetLetterIndex + j) % 26;
                cipherLine.append(this.alphabet.charAt(cipherIndex));
            }

            cipher.add(cipherLine.toString());
        }
        return cipher;
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
            // actual cipher table line and index of actual text letter
            cipherLine = this.cipherTable.get(i % this.keyword.length());
            cipherLetterIndex = cipherLine.indexOf(inputFile.charAt(i));

            // reverse alphabet letter based on cipher letter index in line
            alphabetLetter = this.alphabet.charAt(cipherLetterIndex);
            decipheredText.append(alphabetLetter);
        }

        System.out.println(decipheredText);
    }
}
