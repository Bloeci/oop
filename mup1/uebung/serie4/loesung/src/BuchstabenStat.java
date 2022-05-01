import myExceptions.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BuchstabenStat {

    private Map<Character, Integer> buchstabenHaeufigkeit;
    private long buchstabenAnzahl;

    // Constructor
    public BuchstabenStat () {
        this.buchstabenHaeufigkeit = new HashMap<>();
        this.buchstabenAnzahl = 0;

    }


    // Test if file is correct type '.txt'
    private void pruefeDateityp (String dateiname)
            throws FalscherDatentypException
    {
        String dateiname_test = dateiname.toLowerCase();
        if (!dateiname_test.endsWith(".txt")) {
            throw new FalscherDatentypException(dateiname);
        }
    }


    // Update map 'buchstabenHaeufigkeit'
    private void verarbeiteZeichen (char zeichen)
            throws UngueltigesZeichenException
    {
        // Test if char is letter
        if (Character.isLetter(zeichen)) {
            zeichen = Character.toUpperCase(zeichen);
            // Test if existing key
            if (buchstabenHaeufigkeit.containsKey(zeichen)) {
                buchstabenHaeufigkeit.put(zeichen, buchstabenHaeufigkeit.get(zeichen)+1);
            } else {
                buchstabenHaeufigkeit.put(zeichen, 1);
            }
            this.buchstabenAnzahl++;

        } else {
            // char is not a letter -> test if unicode -> if not throw exception
            if (!Character.isDefined(zeichen)) {
                throw new UngueltigesZeichenException();
            }
        }
    }


    // Check every char in line with method 'verarbeiteZeichen'
    private void verarbeiteZeile (String zeile)
            throws UngueltigesZeichenException
    {
        for (int i = 0; i < zeile.length(); i++)
        {
            char aktuellesZeichen = zeile.charAt(i);
            verarbeiteZeichen(aktuellesZeichen);
        }
    }


    // Processing a given file
    public void analysiere(String dateiname)
            throws FalscherDatentypException, UngueltigesZeichenException
    {
        // Read file
        File inputFile = new File(dateiname);
        int currentLine = 1;
        try {
            pruefeDateityp(dateiname);
            FileReader fileReader = new FileReader(inputFile, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read lines and analyse with method 'verarbeiteZeile'
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                verarbeiteZeile(line);
                currentLine++;
            }

            bufferedReader.close();
            fileReader.close();
            System.out.println("[Info] Analyse von '" + dateiname + "' beendet.");

        } catch (FileNotFoundException exFnF)  {
            System.err.println("[Warnung] Zu analysierende Datei wurde nicht gefunden.\nProgramm wird beendet!\n");
            //exFnF.printStackTrace();
            System.exit(1);

        } catch (IOException exIO) {
            System.err.println("[Warnung] Fehlerhafte Ein-/Ausgabe bei der Analyse.\nProgramm wird beendet!\n");
            //exIO.printStackTrace();
            System.exit(1);

        } catch (UngueltigesZeichenException e) {
            throw new UngueltigesZeichenException(dateiname, currentLine);
        }

        // End try-Block
    }


    // Print statistics from map<char, int>
    public String statistik ()
    {
        TreeMap<Character, Integer> sortierteMap = new TreeMap<>(buchstabenHaeufigkeit);

        StringBuilder ausgabe = new StringBuilder();
        for (char zeichen : sortierteMap.keySet())
        {
            double aktuelleHaeufigkeit = (double)sortierteMap.get(zeichen)/buchstabenAnzahl;
            ausgabe.append(String.format("%c: %.2f \n", zeichen, aktuelleHaeufigkeit));
        }

        return ausgabe.toString();
    }


    // Write to file <- from method 'statistik'
    public void schreibeStatistik(String dateiname)
    {
        String statistikResult = statistik();

        // Create output directory, if not exist
        File directory = new File(System.getProperty("user.dir") + "/ausgabe");
        if (!directory.exists()) { directory.mkdir();}

        int loc = dateiname.indexOf(".");
        dateiname = dateiname.substring(0, loc) + "Statistik.txt";

        // Create File and write output (try-Block)
        File newFile = new File(directory + "/" + dateiname);
        try {
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(statistikResult);

            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("[Info] Schreiben der Datei '" + dateiname + "' abgeschlossen.");

        } catch (IOException eIO) {
            System.err.println(
                    "[Warnung] Fehlerhafte Ein-/Ausgabe beim schreiben der Daten.\nProgramm wird beendet!\n"
            );
            //eIO.printStackTrace();
            System.exit(1);
        }

    }


    // Show Top 10 of result in 'buchstabenHaeufigkeit'
    public void zeigeTop10()
    {
        if (!buchstabenHaeufigkeit.isEmpty())
        {
            List<Map.Entry<Character, Integer>> pairKV = new ArrayList<>(buchstabenHaeufigkeit.entrySet());
            pairKV.sort(Map.Entry.comparingByValue());
            Collections.reverse(pairKV);

            // Output
            System.out.println("\nBuchstaben Top 10:");
            for (int i = 0; i < 10; i++) {
                System.out.println(pairKV.get(i).getKey() + ": " + pairKV.get(i).getValue());
            }
            System.out.println();

        } else {
            System.out.println("[Hinweis] Noch keine Analyse durchgefuehrt. Keine Anzeige moeglich.");
        }
    }

}
