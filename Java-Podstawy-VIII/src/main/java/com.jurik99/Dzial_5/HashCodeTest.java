package Dzial_5;

public class HashCodeTest
{
    public static void main(String[] args)
    {
        String word1 = "Witaj";
        String word2 = "Henryk";
        String word3 = "Kwiatek";
        String word4 = "Witaj";

        System.out.println(word1.hashCode());
        System.out.println(word2.hashCode());
        System.out.println(word3.hashCode());
        System.out.println(word4.hashCode());


        System.out.println();


        /**
         * Kody mieszająace łańcuchów są POCHODNYMI ICH ZAWARTOŚCI
         */
        String s = "OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() +"\t"+ sb.hashCode());

        String t = "OK";
        StringBuilder st = new StringBuilder(t);
        System.out.println(t.hashCode() +"\t"+ st.hashCode());


    }
}
