import oop_vignere_chiffre.DeCipher;

import java.util.*;

public class Main {
    public static void main(String[] args){

        DeCipher decipher = new DeCipher("scheune");
        ArrayList<String> table = decipher.getCipherTable();

        for (String line : table){
            System.out.println(line);
        }

        String text = "polalphabetisch";
        String secret = cipher(text, table);
        decipher.decipherText(secret, text);

    }

    private static String cipher(String text, List<String> lookUpTable) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder cipheredText = new StringBuilder();

        char cipherLetter;
        int alphabetLetterIndex;
        String cipherLine;
        for (int i = 0; i < text.length(); i++) {
            alphabetLetterIndex = alphabet.indexOf(text.charAt(i));
            cipherLine = lookUpTable.get(i % lookUpTable.size());
            cipherLetter = cipherLine.charAt(alphabetLetterIndex);

            cipheredText.append(cipherLetter);
        }

        System.out.println(cipheredText);
        return cipheredText.toString();
    }

}
