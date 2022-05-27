import oop_vignere_chiffre.CipherTable;
import oop_vignere_chiffre.DeCipher;
import oop_vignere_chiffre.Exceptions.WrongCharacterException;
import oop_vignere_chiffre.Exceptions.WrongDatatypeException;
import oop_vignere_chiffre.IOFiles;

import java.util.List;

public class Main {
    public static void main(String[] args){
        DeCipher deCipher = new DeCipher("scheune");

        /*
        String content = "polalphabetisch";
        System.out.println(content);
        String cipherText = cipherAText(content, cipher.getKeyword());
        cipher.decipherText(cipherText, "hello");
        */
        deCipher.decipherText("daten/gedicht_cipher.txt", "test01.txt");
    }

    /**
     * Cipher a given text with vignere chiffre.
     */
    private static String cipherAText(String text, String keyword) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder cipheredText = new StringBuilder();

        List<String> lookUpTable = CipherTable.generateCipherTable(keyword);

        char cipherLetter;
        int alphabetLetterIndex;
        String cipherLine;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                alphabetLetterIndex = alphabet.indexOf(text.charAt(i));
                cipherLine = lookUpTable.get(i % lookUpTable.size());
                cipherLetter = cipherLine.charAt(alphabetLetterIndex);
            } else {
                cipherLetter = text.charAt(i);
            }

            cipheredText.append(cipherLetter);
        }

        System.out.println(cipheredText);
        return cipheredText.toString();
    }
}
