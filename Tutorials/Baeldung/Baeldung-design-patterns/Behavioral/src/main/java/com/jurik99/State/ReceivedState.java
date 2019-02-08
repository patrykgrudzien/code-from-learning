package com.jurik99.State;

public class ReceivedState implements PackageState {

    @Override
    public void next(final Package pkg) {
        System.out.println("This package is already received by a client.");
    }

    @Override
    public void prev(final Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package was received by client.");
    }

    @Override
    public String toString() {
        return "ReceivedState{}";
    }
}
