package rekursion;

public class PseudocodeUebung
{
    /*
    WENN arr mehr als 1 Element enthält
        teile arr in zwei Hälften arr1 und arr2
        berechne das Maximum m1 für arr1
        berechne das Maximum m2 für arr2
        GEBE das Maximum von m1 und m2 ZURÜCK
    SONST
        GEBE das enthaltene Element ZURÜCK

    Hinweis: das Maximum zweier int-Werte lässt sich mit Math.max ermitteln
     */
    public static int maximum(int[] arr)
    {
        if (arr.length > 1)
        {
            int[] arr1 = new int[arr.length / 2];
            int[] arr2 = new int[arr.length - arr1.length];
            for (int k = 0; k < arr1.length; k++)
            {
                arr1[k] = arr[k];
            }
            for (int k = arr1.length; k < arr.length; k++)
            {
                arr2[k - arr1.length] = arr[k];
            }
            return Math.max(maximum(arr1), maximum(arr2));
        }
        return arr[0];
    }
}
