package vererbung;

// Frage 4:
public class Buch extends Medium
{
    private String autor;

    public Buch(String titel, String autor)
    {
        super(titel);
        this.autor = autor;
    }

    public String getAutor()
    {
        return autor;
    }

    public String toString()
    {
        return super.toString() + " Autor: " + autor;
    }

    // Frage 5:
    // Gegeben sei eine Variable namens o vom Typ Object.
    // Geben Sie einen Ausdruck an, dessen Wert true genau dann ergibt,
    // wenn o eine Instanz der Klasse Buch oder einer ihrer Unterklasse ist?
    //
    // o instanceof Buch
}
