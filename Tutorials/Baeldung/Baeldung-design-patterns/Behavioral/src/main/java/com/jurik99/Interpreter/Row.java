package com.jurik99.Interpreter;

class Row {

    private final String name;
    private final String surname;

    Row(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
