package com.jurik99.Factory;

public class ComputerFactory
{
    public static Computer getComputer(final TYPE type, final String ram, final String hdd, final String cpu)
    {
        if (type == TYPE.PC) return new PC(ram, hdd, cpu);
        else if (type == TYPE.SERVER) return new Server(ram, hdd, cpu);

        return null;
    }

    private ComputerFactory()
    {

    }

    enum TYPE
    {
        PC, SERVER
    }
}
