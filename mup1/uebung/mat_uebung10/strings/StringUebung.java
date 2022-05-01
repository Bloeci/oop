package strings;

public class StringUebung
{
    // Was macht die Methode stringUebung1?
    // Antwort:
    public static void stringUebung1()
    {
        String eingabe = "Alabama";
        for (int k = 0; k < eingabe.length(); k++)
        {
            char c = eingabe.charAt(k);
            if (c == 'a')
            {
                continue;
            }
            if (c == 'b')
            {
                break;
            }
            System.out.println(c);
        }
    }



    // Was macht die Methode stringUebung2?
    // Antwort:
    public static void stringUebung2()
    {
        String eingabe = "MuP ist toll!";
        String foo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int k = eingabe.length() - 1; k >= 0; k--)
        {
            if (foo.indexOf(eingabe.charAt(k)) == -1)
            {
                sb.append(eingabe.charAt(k));
            }
        }
        System.out.println(sb.toString());
    }



    // Was macht die Methode stringUebung3?
    // Antwort:
    public static void stringUebung3()
    {
        String eingabe = "Alabama";
        // replaceAll ersetzt jedes Auftreten des ersten Parameters durch den zweiten Parameter
        eingabe.replaceAll("a", "c");
        eingabe += "c";
        System.out.println(eingabe.indexOf('c'));
    }



    // Was macht die Methode stringUebung4?
    // Antwort:
    public static void stringUebung4()
    {
        System.out.println(stringUebung4Sub("Alabama"));
        System.out.println(stringUebung4Sub("ALABA"));
        System.out.println(stringUebung4Sub("AAL"));
        System.out.println(stringUebung4Sub("AAA"));
    }

    private static boolean stringUebung4Sub(String eingabe)
    {
        if (eingabe.length() <= 1)
        {
            return true;
        }
        return eingabe.charAt(0) == eingabe.charAt(1) &&
                stringUebung4Sub(eingabe.substring(1));
    }



    // stringUebung5 kann übersprungen werden
    public static void stringUebung5()
    {
        System.out.println(stringUebung5Sub("abcxyz", "defuvw"));
        System.out.println(stringUebung5Sub("abcxyz", "bcdyzÄ"));
    }

    private static boolean stringUebung5Sub(String eingabe1, String eingabe2)
    {
        if (eingabe1.equals("") || eingabe2.equals(""))
        {
            return true;
        }
        return eingabe1.compareTo(eingabe2) < 0 &&
                stringUebung5Sub(eingabe1.substring(1), eingabe2.substring(1));
    }


    // Was macht die Methode stringUebung6?
    // Antwort:
    public static void stringUebung6()
    {
        System.out.println(stringUebung6Sub("test"));
        System.out.println(stringUebung6Sub("heizölrückstoßdämpfung"));
    }

    private static boolean stringUebung6Sub(String eingabe)
    {
        if (eingabe.length() <= 1)
        {
            return true;
        }
        return eingabe.lastIndexOf(eingabe.charAt(0)) == 0 &&
                stringUebung6Sub(eingabe.substring(1));
    }



    // Ersetzen Sie die Funktion endsWith(String s) der Klasse String durch eine eigene Implementierung
    // stringUebung7(text, endung) soll true zurueckgeben, wenn text auf endung endet
    public static boolean stringUebung7(String text, String endung)
    {
        // Jeder String endet mit dem leeren String
        if (endung.equals(""))
        {
            return true;
        }
        // Ein leeren String kann auf keinen anderen String als den leeren String enden
        if (text.equals(""))
        {
            return false;
        }
        return text.substring(text.length() - endung.length()).equals(endung);
    }
}