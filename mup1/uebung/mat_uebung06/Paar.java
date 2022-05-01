/*
  Die Klasse Paar besitzt zwei Typparameter: ErsterDatentyp und ZweiterDatentyp.
  Bei der Erzeugung einer neuen Paar-Instanz müssen diese beiden Typparameter durch
  konkrete Klassennamen ersetzt und mit angegeben werden (Beispiel: Paar<String, Double>, siehe PaarMain).
  Innerhalb der Klasse Paar dienen ErsterDatentyp und ZweiterDatentyp als Typvariablen,
  d.h. die repräsentieren die jeweilige Klasse, die bei der Erzeugung einer Paar-Instanz
  angegeben wurde. Im obigen Beispiel Paar<String, Double> steht ErsterDatentyp für
  die Klasse String und ZweiterDatentyp für die Klasse Double.
 */

public class Paar<ErsterDatentyp, ZweiterDatentyp>
{
    private ErsterDatentyp ersterWert;
    private ZweiterDatentyp zweiterWert;

    public Paar()
    {

    }

    public Paar(ErsterDatentyp ersterWert, ZweiterDatentyp zweiterWert)
    {
        this.ersterWert = ersterWert;
        this.zweiterWert = zweiterWert;
    }

    public ErsterDatentyp getErsterWert()
    {
        return ersterWert;
    }

    public void setErsterWert(ErsterDatentyp ersterWert)
    {
        this.ersterWert = ersterWert;
    }

    public ZweiterDatentyp getZweiterWert()
    {
        return zweiterWert;
    }

    public void setZweiterWert(ZweiterDatentyp zweiterWert)
    {
        this.zweiterWert = zweiterWert;
    }
}
