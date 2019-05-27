package DesignPatterns.Builder.Part_2_3.Classic_Builder;

import DesignPatterns.Builder.Part_2_3.Entities.Car;

public class Client
{
    public static void main(String[] args)
    {
        CarBuilder carBuilder = new RaceCarBuilder();
        CarDirector carDirector = new CarDirector(carBuilder);
        carDirector.makeCar();

        Car car = carDirector.getCar();
        System.out.println(car);
    }
}
