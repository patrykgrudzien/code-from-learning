package com.jurik99.Decorator.practise;

import java.math.BigDecimal;

class Salami extends ToppingDecorator {

    Salami(final Pizza pizza) {
        super(pizza);
        System.out.println("Salami constructor.");
    }

    @Override
    BigDecimal getToppingPrice() {
        return new BigDecimal("10.00");
    }
}
