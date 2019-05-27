package DesignPatterns.Builder.Part_2_3.PractiseNo2;

public class Main
{
    public static void main(String[] args)
    {
        Builder builder = new Ferrari();
        Director director = new Director(builder);
        director.makeCar();

        Car car = director.getCar();
        System.out.println(car);
    }
}
