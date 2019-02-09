package com.jurik99.Facade.carsystem;

public class Radiator {

    public void on() {
        System.out.println("Radiator switched on!");
    }

    public void off() {
        System.out.println("Radiator switched off!");
    }

    public void setSpeed(final Integer speed) {
        System.out.println("Setting radiator speed to " + speed);
    }
}
