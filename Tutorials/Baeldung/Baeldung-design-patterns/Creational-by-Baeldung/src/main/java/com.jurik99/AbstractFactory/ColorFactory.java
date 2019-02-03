package com.jurik99.AbstractFactory;

import com.jurik99.AbstractFactory.ColorFactory.ColorType;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.is;

public class ColorFactory implements AbstractFactory<Color, ColorType> {

    @Override
    public Color create(final ColorType colorType) {
        return Match(colorType).of(
                Case($(is(ColorType.BLUE)), Blue::new),
                Case($(is(ColorType.RED)), Red::new),
                Case($(), () -> null)
        );
    }

    public enum ColorType {
        BLUE, RED
    }
}
