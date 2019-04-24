package com.jurik99.Decorator.practise;

import java.math.BigDecimal;

public abstract class ToppingDecorator implements Pizza {

    private final Pizza pizza;

    ToppingDecorator(final Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getPrice() {
        return pizza.getPrice();
    }
}
