import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Portal
{
    private Map<Integer, Hotel> datenbank;

    public Portal() {
         datenbank = new HashMap<>();
    }


    public int leseBewertungen(String dateiname) {
        int zeilennummer = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiname)))
        {
            String zeile;
            while ((zeile = reader.readLine()) != null) {
                zeilennummer++;
                String[] sp = zeile.split(";");
                try {
                    bewertungHinzufuegen(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3]));
                }
                catch (UngueltigeBewertungException exception) {
                    System.out.println(String.format("Fehler in Zeile %d von %s: %s", zeilennummer, dateiname, exception.getMessage()));
                }
            }
            return zeilennummer;
        }
        catch (IOException exception) {
            System.out.println("Fehler beim Einlesen der Bewertungen");
            return zeilennummer;
        }
    }

    private void bewertungHinzufuegen(int hotelID, int ausstattung, int essen, int personal) throws UngueltigeBewertungException {
        if (!datenbank.containsKey(hotelID)) {
            throw new UngueltigeBewertungException(hotelID);
        }
        if (ausstattung < 0 || ausstattung > 10) {
            throw new UngueltigeBewertungException("Ausstattung", ausstattung);
        }
        if (essen < 0 || essen > 10) {
            throw new UngueltigeBewertungException("Essen", essen);
        }
        if (personal < 0 || personal > 10) {
            throw new UngueltigeBewertungException("Personal", personal);
        }
        datenbank.get(hotelID).bewertungHinzufuegen(new Bewertung(ausstattung, essen, personal));
    }


    public void hotelAusgeben(int hotelID, String dateiname) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateiname))) {
            writer.write(datenbank.get(hotelID).toString());
        }
        catch (IOException exception) {
            System.out.println("Fehler beim Schreiben");
        }
    }


    public int leseDatenbank(String dateiname)
    {
        int anzahlIDs = 0;
        try (InputStream input = new FileInputStream(dateiname))
        {
            byte[] daten = new byte[4];
            input.read(daten);
            anzahlIDs = byteToInt(daten);
            for (int k = 0; k < anzahlIDs; k++) {
                input.read(daten);
                int id = byteToInt(daten);
                datenbank.put(id, new Hotel(id));
            }
            return anzahlIDs;
        }
        catch (IOException exception) {
            System.out.println("Fehler beim Einlesen der Datenbank");
            return anzahlIDs;
        }
    }


    private int byteToInt(byte[] bytes) {
        if (bytes.length != 4) {
            System.out.println("Fehlerhaftes byte-Array");
            System.exit(1);
        }
        return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
    }
}
