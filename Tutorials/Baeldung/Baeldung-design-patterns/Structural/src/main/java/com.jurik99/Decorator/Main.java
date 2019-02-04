package com.jurik99.Decorator;

/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 * This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
 *
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
 */
public class Main {

    public static void main(String[] args) {

        final ChristmasTree christmasTree = new Garland(new ChristmasTreeImpl());
        System.out.println("christmasTree.decorate() = " + christmasTree.decorate());

        final ChristmasTree treeWithTwoGarland = new Garland(new Garland(new ChristmasTreeImpl()));
        System.out.println("treeWithTwoGarland.decorate() = " + treeWithTwoGarland.decorate());

        final ChristmasTree treeWithGarlandAndLights = new Garland(new Lights(new ChristmasTreeImpl()));
        System.out.println("treeWithGarlandAndLights.decorate() = " + treeWithGarlandAndLights.decorate());
    }
}
