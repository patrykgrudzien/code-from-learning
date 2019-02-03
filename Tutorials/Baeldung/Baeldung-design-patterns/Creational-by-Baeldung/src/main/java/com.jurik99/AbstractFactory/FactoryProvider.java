package com.jurik99.AbstractFactory;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.is;

final class FactoryProvider {

    private FactoryProvider() {}

    static AbstractFactory getFactory(final FactoryType factoryType) {
        return Match(factoryType).of(
                Case($(is(FactoryType.ANIMAL)), AnimalFactory::new),
                Case($(is(FactoryType.COLOR)), ColorFactory::new)
        );
    }

    public enum FactoryType {
        ANIMAL, COLOR
    }
}
