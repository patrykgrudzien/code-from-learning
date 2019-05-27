package DesignPatterns.Builder.Part_2_3.PractiseNo1;

public class TestBuild
{
    public static void main(String[] args)
    {
        HouseBuilder builder = new PatrykHouse();
        HouseDirector director = new HouseDirector(builder);
        director.buildHouse();

        House patrykHouse = director.getHouse();
        System.out.println(patrykHouse);
    }
}
