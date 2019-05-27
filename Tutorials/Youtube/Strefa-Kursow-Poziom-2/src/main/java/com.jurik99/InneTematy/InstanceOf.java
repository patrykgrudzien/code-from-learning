package InneTematy;

public class InstanceOf
{
    public static void main(String[] args)
    {
        String s = null;

        if (s instanceof String)
        {
            System.out.println("Instanceof zwraca TRUE");
        }
        else
        {
            System.out.println("Instanceof zwraca FALSE");
        }
    }
}
