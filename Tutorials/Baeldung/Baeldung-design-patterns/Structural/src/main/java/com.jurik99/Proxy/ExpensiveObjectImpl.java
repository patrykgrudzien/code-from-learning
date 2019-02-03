package com.jurik99.Proxy;

public class ExpensiveObjectImpl implements ExpensiveObject {

    ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        System.out.println("Processing complete.");
    }

    private void heavyInitialConfiguration() {
        System.out.println("Loading initial configuration...");
    }
}
