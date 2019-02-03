package com.jurik99.AbstractFactory;

import com.jurik99.AbstractFactory.AnimalFactory.AnimalType;
import com.jurik99.AbstractFactory.ColorFactory.ColorType;
import com.jurik99.AbstractFactory.FactoryProvider.FactoryType;

public class Main {

    public static void main(String[] args) {

        //noinspection unchecked
        final Animal animal = (Animal) FactoryProvider.getFactory(FactoryType.ANIMAL)
                                                      .create(AnimalType.DOG);

        System.out.println("animal.getType() = " + animal.getType());
        System.out.println("animal.makeSound() = " + animal.makeSound());

        //noinspection unchecked
        final Color color = (Color) FactoryProvider.getFactory(FactoryType.COLOR)
                                                   .create(ColorType.BLUE);
        System.out.println("color.getColor() = " + color.getColor());
    }
}
