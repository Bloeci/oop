package oop_vignere_chiffre;
import java.util.ArrayList;

public class CipherTable {
    /**
     * Generate a cipher table based on a given keyword length n.
     * @param keyword   String to decipher a given text.
     * @return cipher   Lookup table with size n.
     */
    public static ArrayList<String> generateCipherTable(String keyword){
        keyword = keyword.toLowerCase().replaceAll("\\s+", "");
        // validateKeyword(keyword);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> cipher = new ArrayList<>(keyword.length());

        int alphabetLetterIndex, cipherIndex;
        char keywordLetter;
        for (int i = 0; i < keyword.length(); i++) {
            // get actual letter in keyword and index in alphabet
            keywordLetter = keyword.charAt(i);
            alphabetLetterIndex = alphabet.indexOf(keywordLetter);

            StringBuilder cipherLine = new StringBuilder();
            // iterate throw alphabet with modulo index
            for (int j = 0; j < 26; j++) {
                cipherIndex = (alphabetLetterIndex + j) % 26;
                cipherLine.append(alphabet.charAt(cipherIndex));
            }
            cipher.add(cipherLine.toString());
        }

        return cipher;
    }

    /**
     * Validate the given keyword by an arbitrary scaling.
     * @param keyword   The given keyword. Only letters.
     */
    private static void validateKeyword(String keyword){
        StringBuilder temp= new StringBuilder();
        for (int i = 0; i < keyword.length(); i++) {
            if (temp.toString().indexOf(keyword.charAt(i)) == -1 ) {
                temp.append(keyword.charAt(i));
            }
        }
        String validation;
        float frac = (float)temp.length()/keyword.length();
        if (frac > 0.90){
            validation = "best";
        } else if (frac > 0.60) {
            validation = "good";
        } else if (frac > 0.30) {
            validation = "not good";
        } else {
            validation = "take another";
        }
        System.out.printf("Keyword: %s, Unique characters: %d/%d (%.1f %%), Validation: %s\n",
                keyword, temp.length(), keyword.length(), frac*100, validation);
    }
}
