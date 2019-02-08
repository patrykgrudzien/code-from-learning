package com.jurik99.State;

public class OrderedState implements PackageState {

    @Override
    public void next(final Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(final Package pkg) {
        System.out.println("The package is in it's root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Package ordered, not delivered to the office yet.");
    }

    @Override
    public String toString() {
        return "OrderedState{}";
    }
}

