package com.jurik99.AbstractFactory;

import com.jurik99.AbstractFactory.AnimalFactory.AnimalType;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.is;

public class AnimalFactory implements AbstractFactory<Animal, AnimalType> {

    @Override
    public Animal create(final AnimalType animalType) {
        return Match(animalType).of(
                Case($(is(AnimalType.DOG)), Dog::new),
                Case($(is(AnimalType.DUCK)), Duck::new),
                Case($(), () -> null)
        );
    }

    public enum AnimalType {
        DOG, DUCK
    }
}
