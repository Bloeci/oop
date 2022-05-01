public class Main
{
    public static void main(String[] args)
    {
        Portal portal = new Portal();
        int eingeleseneIds = portal.leseDatenbank("Hotels.mupdb");
        System.out.println("Eingelesene IDs: " + eingeleseneIds);
        int eingeleseneBewertungen = portal.leseBewertungen("Bewertungen.txt");
        System.out.println("Eingelesene Bewertungen: " + eingeleseneBewertungen);
        portal.hotelAusgeben(135693, "Hotel135693.txt");

    }
}
