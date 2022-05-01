public class Bewertung
{
    private int ausstattung;
    private int essen;
    private int personal;

    public Bewertung(int ausstattung, int essen, int personal) {
        this.ausstattung = ausstattung;
        this.essen = essen;
        this.personal = personal;
    }

    public String toString() {
        return "Ausstattung: " + ausstattung + ", Essen: " + essen + ", Personal: " + personal;
    }
}
