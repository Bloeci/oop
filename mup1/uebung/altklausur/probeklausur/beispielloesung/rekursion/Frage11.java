package rekursion;

public class Frage11
{
    // Frage 11:
    public int fib( int n ){
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return 1;
        }
        if (n > 1)
        {
            return fib(n - 1) + fib(n - 2);
        }
        return -1;
    }
}
