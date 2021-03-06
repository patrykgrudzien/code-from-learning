package PrzydatneKlasy;

public class StringBufferTest
{
    public static void main(String[] args)
    {
        String s = "Kasia";
        /**
         * s = new StringBuffer(s).append(" i Tomek").toString();
         *
         * Złożoność obliczeniowa jest w tym przypadku fatalna
         */
        s = s + " i Tomek";
        System.out.println(s);


        // ------ SPOSÓB 1 ------ //
        String s1 = "a";
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++)
        {
            s1+= "a";
            // s1 = new StringBuffer(s).append(" i Tomek").toString();
        }
        System.out.println("Time 1: " +(System.nanoTime() - start));


        // ------ SPOSÓB 2 ------ //
        String s2 = "a";
        long start2 = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer(s2);
        for (int i = 0; i < 100000; i++)
        {
            stringBuffer.append("a");
        }
        s2 = stringBuffer.toString();
        System.out.println("Time 2: " +(System.nanoTime() - start2));


        // ------ SPOSÓB 3 ------ //
        /**
         * StringBuffer jest klasą synchroniczną, natomiast StringBuilder nie
         */
        String s3 = "a";
        long start3 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder(s3);
        for (int i = 0; i < 100000; i++)
        {
            stringBuilder.append("a");
        }
        s3 = stringBuilder.toString();
        System.out.println("Time 3: " +(System.nanoTime() - start3));
    }
}
