package arrays;

public class Frage10
{
    // Frage 10:
    public static void sortieren(int[] zahlen)
    {
        int pos = 0;
        while (pos < zahlen.length)
        {
            if (pos == 0 || zahlen[pos] >= zahlen[pos-1])
            {
                pos++;
            }
            else
            {
                int temp = zahlen[pos];
                zahlen[pos] = zahlen[pos - 1];
                zahlen[pos - 1] = temp;
                pos--;
            }
        }
    }
}
