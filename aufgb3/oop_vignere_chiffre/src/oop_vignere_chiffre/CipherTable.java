package oop_vignere_chiffre;

import java.util.ArrayList;

public class CipherTable {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Generate a cipher table based on a given keyword length n.
     * @param keyword   String to decipher a given text.
     * @return cipher  Lookup table with size n.
     */
    public ArrayList<String> generateCipherTable(String keyword){
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


}
