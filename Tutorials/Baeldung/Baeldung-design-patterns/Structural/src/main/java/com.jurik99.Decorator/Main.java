package com.jurik99.Decorator;

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
