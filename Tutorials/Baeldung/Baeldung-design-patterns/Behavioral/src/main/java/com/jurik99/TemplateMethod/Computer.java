package com.jurik99.TemplateMethod;

import java.util.Map;

public class Computer {

    private final Map<String, String> computerParts;

    Computer(final Map<String, String> computerParts) {
        this.computerParts = computerParts;
    }

    Map<String, String> getComputerParts() {
        return computerParts;
    }
}
