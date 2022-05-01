public class PaarMain
{
    public static void main(String[] args)
    {
        Paar<String, Double> einPaar = new Paar<>();
        einPaar.setErsterWert("MuP");
        einPaar.setZweiterWert(1.0);
        System.out.println(einPaar.getErsterWert());
        System.out.println(einPaar.getZweiterWert());

        Paar<Integer, Integer> nochEinPaar = new Paar<>(12,34);
        System.out.println(nochEinPaar.getErsterWert());
        System.out.println(nochEinPaar.getZweiterWert());
    }
}
