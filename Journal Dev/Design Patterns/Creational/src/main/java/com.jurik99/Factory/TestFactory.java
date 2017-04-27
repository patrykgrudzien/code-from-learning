package com.jurik99.Factory;

public class TestFactory
{
    public static void main(String[] args)
    {
        Computer pc = ComputerFactory.getComputer(ComputerFactory.TYPE.PC, "2GB", "500GB", "2,4GHz");
        Computer server = ComputerFactory.getComputer(ComputerFactory.TYPE.SERVER, "16GB", "1TB", "2,9GHz");

        System.out.println(pc);
        System.out.println(server);
    }
}
