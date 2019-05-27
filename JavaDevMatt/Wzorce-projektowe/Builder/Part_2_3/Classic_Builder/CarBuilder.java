package DesignPatterns.Builder.Part_2_3.Classic_Builder;

import DesignPatterns.Builder.Part_2_3.Entities.Car;

public interface CarBuilder
{
    void buildTires();

    void buildEngine();

    Car getCar();
}
