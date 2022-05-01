public class UngueltigeBewertungException extends Exception
{
    public UngueltigeBewertungException(int hotelID) {
        super(String.format("ID %d nicht gefunden", hotelID));
    }

    public UngueltigeBewertungException(String kategorie, int wert) {
        super(String.format("Ungültige Bewertung (%d) in der Kategorie %s", wert, kategorie));
    }
}
