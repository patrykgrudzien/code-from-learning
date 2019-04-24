package com.jurik99.Decorator.practise;

import java.math.BigDecimal;

public class PizzaImpl implements Pizza {

    PizzaImpl() {
        System.out.println("PizzaImpl constructor.");
    }

    @Override
    public BigDecimal getPrice() {
        System.out.println("PizzaImpl price.");
        return new BigDecimal("20.00");
    }
}
