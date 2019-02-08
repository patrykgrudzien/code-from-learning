package com.jurik99.State;

public class Package {

    private PackageState state = new OrderedState();

    public PackageState getState() {
        return state;
    }

    void setState(final PackageState state) {
        this.state = state;
    }

    void previousState() {
        state.prev(this);
    }

    void nextState() {
        state.next(this);
    }

    void printStatus() {
        state.printStatus();
    }
}