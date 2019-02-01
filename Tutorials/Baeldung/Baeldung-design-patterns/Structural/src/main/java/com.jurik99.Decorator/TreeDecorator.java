package com.jurik99.Decorator;

import lombok.Data;

@Data
public abstract class TreeDecorator implements ChristmasTree {

    private ChristmasTree christmasTree;

    TreeDecorator(final ChristmasTree christmasTree) {
        this.christmasTree = christmasTree;
    }

    @Override
    public String decorate() {
        return christmasTree.decorate();
    }
}
