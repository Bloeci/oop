package vererbung;

public class Medium implements Comparable<Medium>{
    private String titel;

    public Medium(String titel) {
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    @Override public String toString() {
        return "Titel: " + titel;
    }


    // Frage 3:
    @Override
    public int compareTo(Medium o)
    {
        return titel.compareTo(o.titel);
    }
}
