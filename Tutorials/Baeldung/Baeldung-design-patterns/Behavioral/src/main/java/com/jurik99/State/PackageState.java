package com.jurik99.State;

public interface PackageState {

    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}
