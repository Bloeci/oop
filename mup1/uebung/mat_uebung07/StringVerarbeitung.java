public class StringVerarbeitung
{
    // reverse soll einen String umkehren.
    public static String reverse(String input)
    {
        String output = "";
        for (int i = input.length(); i > 0; i--)
        {
            output = output + input.charAt(i - 1);
            // Alternativ:
            // output = output + input.substring(i - 1, i);

        }
        return output;
    }


    // toggleCase soll alle Kleinbuchstaben eines Strings in Großbuchstaben und
    // alle Großbuchstaben in Kleinbuchstaben umwandeln.
    public static String toggleCase(String input)
    {
        String output = "";
        for (int i = 0; i < input.length(); i++)
        {
            String ch = String.valueOf(input.charAt(i));
            // Alternativ:
            //String ch = input.substring(i, i+1);
            if (ch.equals(ch.toLowerCase()))
            {
                output += ch.toUpperCase();
            }
            else
            {
                output += ch.toLowerCase();
            }
        }
        return output;
    }

    // In caesar sollen alle Buchstaben im String input um zahl viele Zeichen verschoben werden.
    // Ist z.B. zahl gleich drei, soll aus einem 'A' ein 'D' werden.
    public static String caesar(String input, int zahl)
    {
        String output = "";
        for (int i = 0; i < input.length(); i++)
        {
            output += (char)(input.charAt(i) + zahl);
        }
        return output;
    }


    // palindrom soll testen, ob ein übergebener String ein Palindrom ist, also vorwärts und
    // rückwärts gelesen gleich lautet.
    public static boolean palindrom(String input)
    {
        for (int i = 0; i < input.length() / 2; i++)
        {
            if (!(input.charAt(i) == input.charAt(input.length() - i - 1)))
            {
                return false;
            }
        }
        return true;
    }


    // messeZeit misst die Zeit, die für das Aneinanderfügen von Strings mittels Stringkonkatenation
    // bzw. mittels StringBuilder.append benötigt wird
    public static void messeZeit(int iterationen)
    {
        long start = System.currentTimeMillis();
        String erg = "";
        for (int k = 0; k < iterationen; k++)
        {
            erg += "A";
        }
        long ende = System.currentTimeMillis();
        System.out.println(String.format("\nStringkonkatenation: Zeit (in Millisekunden) für %d Iterationen: %d", iterationen, ende - start));

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        for (int k = 0; k < iterationen; k++)
        {
            sb.append("A");
        }
        erg = sb.toString();
        ende = System.currentTimeMillis();
        System.out.println(String.format("StringBuilder: Zeit (in Millisekunden) für %d Iterationen: %d", iterationen, ende - start));
    }


    public static void main(String[] args)
    {
        String text = "MuP1_ist_TOLL!";
        System.out.println("Original:\n" + text);

        System.out.println("\ntoggleCase:");
        System.out.println(toggleCase(text));

        System.out.println("\ncaesar mit zahl gleich 1:");
        System.out.println(caesar(text, 1));

        System.out.println("\nreverse:");
        System.out.println(reverse(text));

        String palindromTest1 = "ABCBA";
        String palindromTest2 = "ABCCBA";
        String palindromTest3 = "ABCAB";
        System.out.println(String.format("\nIst %s ein Palindrom? Antwort: %s", palindromTest1, palindrom(palindromTest1)));
        System.out.println(String.format("Ist %s ein Palindrom? Antwort: %s", palindromTest2, palindrom(palindromTest2)));
        System.out.println(String.format("Ist %s ein Palindrom? Antwort: %s", palindromTest3, palindrom(palindromTest3)));

        messeZeit(10000);
        messeZeit(100000);
    }
}
