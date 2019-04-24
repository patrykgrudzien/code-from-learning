package com.jurik99.Decorator.practise;

import java.math.BigDecimal;

class Cheese extends ToppingDecorator {

    Cheese(final Pizza pizza) {
        super(pizza);
        System.out.println("Cheese constructor.");
    }

    @Override
    BigDecimal getToppingPrice() {
        return new BigDecimal("5.00");
    }
}
