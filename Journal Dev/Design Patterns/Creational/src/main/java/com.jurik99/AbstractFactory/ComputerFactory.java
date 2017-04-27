package com.jurik99.AbstractFactory;

public class ComputerFactory
{
    public static Computer getComputer(ComputerAbstractFactory factory)
    {
        return factory.createComputer();
    }
}
