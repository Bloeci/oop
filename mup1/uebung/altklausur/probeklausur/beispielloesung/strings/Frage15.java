package strings;

public class Frage15
{
    public void frage15()
    {
        String s = "abba";
        System.out.println(s.split("b").length);  // Ausgabe: 3

        StringBuilder a = new StringBuilder("abba");
        a.replace(2, 3, "c");
        a.toString();
        System.out.println(s.split("c").length);  // Ausgabe: 1

        String b = a.reverse().toString();
        String[] t = b.split("c");
        System.out.println(t.length);  // Ausgabe: 2

        System.out.println(t[1]);  // Ausgabe: ba

    }
}
