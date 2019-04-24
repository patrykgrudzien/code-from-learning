package com.jurik99.Decorator.practise;

import java.math.BigDecimal;

public class Cheese extends ToppingDecorator {

    Cheese(final Pizza pizza) {
        super(pizza);
        System.out.println("Cheese constructor.");
    }

    @Override
    public BigDecimal getPrice() {
        System.out.println("Cheese price.");
        return super.getPrice().add(new BigDecimal("5.00"));
    }
}
