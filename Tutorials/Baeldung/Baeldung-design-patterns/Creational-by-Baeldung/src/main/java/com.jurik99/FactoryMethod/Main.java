package com.jurik99.FactoryMethod;

public class Main {

    public static void main(String[] args) {

        final PolygonFactory polygonFactory = new PolygonFactory();

        final Polygon triangle = polygonFactory.getPolygon(3);
        System.out.println("triangle.getType() = " + triangle.getType());

        final Polygon square = polygonFactory.getPolygon(4);
        System.out.println("square.getType() = " + square.getType());

        final Polygon nullPolygon = polygonFactory.getPolygon(8);
        System.out.println("nullPolygon will throw NPE!");
    }
}
