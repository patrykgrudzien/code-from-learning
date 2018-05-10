package com.jurik99.AbstractFactory;

public class ComputerFactory
{
    public static Computer getComputer(final ComputerAbstractFactory factory)
    {
        return factory.createComputer();
    }
}
