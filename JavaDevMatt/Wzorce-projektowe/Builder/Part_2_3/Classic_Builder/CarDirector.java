package DesignPatterns.Builder.Part_2_3.Classic_Builder;

import DesignPatterns.Builder.Part_2_3.Entities.Car;

public class CarDirector
{
    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder)
    {
        this.carBuilder = carBuilder;
    }

    public void makeCar()
    {
        carBuilder.buildEngine();
        carBuilder.buildTires();
    }

    public Car getCar()
    {
        return this.carBuilder.getCar();
    }
}
