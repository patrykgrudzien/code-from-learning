package com.jurik99.Decorator.practise;

public class Main {

    public static void main(final String[] args) {

        final Pizza pizza = new Cheese(new Salami(new PizzaImpl()));
        System.out.println("pizza.getPrice() = " + pizza.getPrice());
    }
}
