package DesignPatterns.Builder.Part_2_3.Classic_Builder;

import DesignPatterns.Builder.Part_2_3.Entities.Car;
import DesignPatterns.Builder.Part_2_3.Entities.Engine;
import DesignPatterns.Builder.Part_2_3.Entities.Tires;

public class RaceCarBuilder implements CarBuilder
{
    private final Car car;

    public RaceCarBuilder()
    {
        this.car = new Car();
    }

    @Override
    public void buildTires()
    {
        Tires tires = new Tires();
        tires.setDurability(50);
        tires.setType("Slics");

        car.setTires(tires);
    }

    @Override
    public void buildEngine()
    {
        Engine engine = new Engine();
        engine.setType("V8");

        car.setEngine(engine);
    }

    @Override
    public Car getCar()
    {
        return car;
    }
}
