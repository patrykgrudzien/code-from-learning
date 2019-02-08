package com.jurik99.TemplateMethod;

public class StandardComputerBuilder extends ComputerBuilder {

    @Override
    protected void addMotherBoard() {
        super.getComputerParts().put("MotherBoard", "Standard MotherBoard");
    }

    @Override
    protected void setupMotherBoard() {
        super.getMotherBoardSetupStatus().add("Screwing the standard motherboard to the case.");
        super.getMotherBoardSetupStatus().add("Plugging in the power supply connectors.");
        super.getMotherBoardSetupStatus().forEach(System.out::println);
    }

    @Override
    protected void addProcessor() {
        super.getComputerParts().put("Processor", "Standard Processor");
    }
}
