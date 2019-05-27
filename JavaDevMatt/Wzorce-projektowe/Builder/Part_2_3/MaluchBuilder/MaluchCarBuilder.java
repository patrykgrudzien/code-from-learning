package DesignPatterns.Builder.Part_2_3.MaluchBuilder;

import DesignPatterns.Builder.Part_2_3.Classic_Builder.CarBuilder;
import DesignPatterns.Builder.Part_2_3.Entities.Car;
import DesignPatterns.Builder.Part_2_3.Entities.Engine;
import DesignPatterns.Builder.Part_2_3.Entities.Tires;

public class MaluchCarBuilder implements CarBuilder
{
    private final Car car;

    public MaluchCarBuilder()
    {
        this.car = new Car();
    }

    @Override
    public void buildTires()
    {
        Tires tires = new Tires();
        tires.setType("Miszelan");
        tires.setDurability(100);

        car.setTires(tires);
    }

    @Override
    public void buildEngine()
    {
        Engine engine = new Engine();
        engine.setType("V12 Maluch");

        car.setEngine(engine);
    }

    @Override
    public Car getCar()
    {
        return car;
    }
}
