import strings.Frage13;
import strings.Frage15;

public class Main
{
    public static void main(String[] args)
    {
        // Frage 13:
        Frage13 f13 = new Frage13();
        System.out.println(f13.foo("abba"));
        System.out.println(f13.foo("Innensechskantwinkelschraubendreher"));

        // Frage 15:
        Frage15 f15 = new Frage15();
        f15.frage15();
    }
}
