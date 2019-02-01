package com.jurik99.FactoryMethod;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

class PolygonFactory {

    Polygon getPolygon(final int numberOfSides) {
        return Match(numberOfSides).of(
                Case($(3), new Triangle()),
                Case($(4), new Square()),
                Case($(), () -> null)
        );
    }
}
