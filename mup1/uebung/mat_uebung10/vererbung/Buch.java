package vererbung;

/*
Die Klasse Buch soll von der Klasse Medium erben.

Sie besitzt die Attribute isbn vom Typ int und autor vom Typ String.

Die Methode toString() soll folgenden String zurückgeben:
Mediennummer: <mediennummer>, Titel: <titel>, ISBN: <isbn>, Autor: <autor>

Die Methode istGesuchtesBuch soll eine Mediennummer und eine ISBN übernehmen und genau dann true zurückgeben,
wenn wenigstens eine der beiden Nummern übereinstimmt
 */
public class Buch extends Medium
{
    private int isbn;
    private String autor;

    public Buch(int mediennummer, String titel, int isbn, String autor)
    {
        super(mediennummer, titel);
        this.isbn = isbn;
        this.autor = autor;
    }


    public boolean istGesuchtesBuch(int mediennummer, int isbn)
    {
        return mediennummer == getMediennummer() || isbn == this.isbn;
    }


    public String toString()
    {
        return super.toString() + ", ISBN: " + isbn + ", Autor: " + autor;
    }

}
