package DesignPatterns.Builder.Part_1_3;

public class TestBuilder
{
    public static void main(String[] args)
    {
        Car car = new Car.Builder("Fiat")
                .model("Bravo")
                .color("Grey")
                .age(8)
                .price(20000.00)
                .build();

        System.out.println(car);

        Car car1 = new Car.Builder().build();
        System.out.println(car1);
    }
}