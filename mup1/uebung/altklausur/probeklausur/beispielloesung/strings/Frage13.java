package strings;

public class Frage13
{
    // Frage 13/14:
    // foo gibt true zurück, wenn der String w ein Palindrom ist, also vorwärts gelesen
    // genauso lautet wie rückwärts gelesen
    public boolean foo(String w)
    {
        StringBuilder s = new StringBuilder(w);
        s.reverse();
        if (w.equals(s.toString()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
