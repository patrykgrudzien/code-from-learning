package com.jurik99.Decorator;

public class Garland extends TreeDecorator {

    Garland(final ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + " decorated with Garland :)";
    }
}
