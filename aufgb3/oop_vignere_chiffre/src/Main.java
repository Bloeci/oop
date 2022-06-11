import oop_vignere_chiffre.Cipher;
import oop_vignere_chiffre.CipherTable;

public class Main {
    public static void main(String[] args){

        String keyword = "scheune";
        Cipher cipher = new Cipher(keyword);
        CipherTable.validateKeyword(keyword);

        cipher.runCipher("./daten/Gedicht.txt",
                "./daten/Gedicht_ciphered.txt", true);
        cipher.decipherText("./daten/Gedicht_ciphered.txt",
                "./daten/Gedicht_deciphered.txt", true);
    }
}
