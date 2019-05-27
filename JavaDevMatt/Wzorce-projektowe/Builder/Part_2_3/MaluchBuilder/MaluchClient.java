package DesignPatterns.Builder.Part_2_3.MaluchBuilder;

import DesignPatterns.Builder.Part_2_3.Classic_Builder.CarBuilder;
import DesignPatterns.Builder.Part_2_3.Classic_Builder.CarDirector;
import DesignPatterns.Builder.Part_2_3.Entities.Car;

public class MaluchClient
{
    public static void main(String[] args)
    {
        CarBuilder carBuilder = new MaluchCarBuilder();
        CarDirector carDirector = new CarDirector(carBuilder);
        carDirector.makeCar();

        Car maluch = carDirector.getCar();
        System.out.println(maluch);
    }
}
