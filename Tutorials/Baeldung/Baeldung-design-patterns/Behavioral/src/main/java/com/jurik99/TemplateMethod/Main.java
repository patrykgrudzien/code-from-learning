package com.jurik99.TemplateMethod;

/**
 * It makes it easier to implement complex algorithms by encapsulating logic in a single method.
 *
 * To demonstrate how the template method pattern works, let’s create a simple example which represents building a computer station.
 * Given the pattern’s definition, the algorithm’s structure will be defined in a base class that defines the template build() method.
 */
public class Main {

    public static void main(final String[] args) {

        final Computer computer = new StandardComputerBuilder().buildComputer();
        computer.getComputerParts().forEach((part, value) -> System.out.println("Part: " + part + ", Value: " + value));
    }
}
