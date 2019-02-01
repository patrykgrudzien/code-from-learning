package com.jurik99.Decorator;

public class Lights extends TreeDecorator {

    Lights(final ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + " decorated with Lights :)";
    }
}
