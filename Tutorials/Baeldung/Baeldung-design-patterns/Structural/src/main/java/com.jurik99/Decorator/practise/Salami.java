package com.jurik99.Decorator.practise;

import java.math.BigDecimal;

public class Salami extends ToppingDecorator {

    Salami(final Pizza pizza) {
        super(pizza);
        System.out.println("Salami constructor.");
    }

    @Override
    public BigDecimal getPrice() {
        System.out.println("Salami price.");
        return super.getPrice().add(new BigDecimal("10.00"));
    }
}
