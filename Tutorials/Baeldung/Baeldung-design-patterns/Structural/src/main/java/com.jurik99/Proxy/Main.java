package com.jurik99.Proxy;

public class Main {

    public static void main(String[] args) {

        final ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
