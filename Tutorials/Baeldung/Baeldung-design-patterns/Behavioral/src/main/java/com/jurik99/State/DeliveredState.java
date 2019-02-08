package com.jurik99.State;

public class DeliveredState implements PackageState {

    @Override
    public void next(final Package pkg) {
        pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(final Package pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package delivered to post office, not received yet.");
    }

    @Override
    public String toString() {
        return "DeliveredState{}";
    }
}
