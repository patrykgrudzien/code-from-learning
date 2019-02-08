package com.jurik99.TemplateMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ComputerBuilder class is responsible for outlining the steps required to build a computer by declaring methods for
 * adding and setting up different components, such as a motherboard and a processor.
 *
 * Here, the build() method is the template method, which defines steps of the algorithm
 * for assembling the computer parts and returns fully-initialized Computer instances.
 *
 * Notice that it’s declared as final to prevent it from being overridden.
 */
public abstract class ComputerBuilder {

    private final Map<String, String> computerParts = new HashMap<>();
    private final List<String> motherBoardSetupStatus = new ArrayList<>();

    // template method
    final Computer buildComputer() {
        addMotherBoard();
        setupMotherBoard();
        addProcessor();
        return getComputer();
    }

    private Computer getComputer() {
        return new Computer(getComputerParts());
    }

    protected abstract void addMotherBoard();

    protected abstract void setupMotherBoard();

    protected abstract void addProcessor();

    Map<String, String> getComputerParts() {
        return computerParts;
    }

    List<String> getMotherBoardSetupStatus() {
        return motherBoardSetupStatus;
    }
}
