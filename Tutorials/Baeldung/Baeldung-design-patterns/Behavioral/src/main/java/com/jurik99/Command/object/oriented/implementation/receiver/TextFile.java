package com.jurik99.Command.object.oriented.implementation.receiver;

/**
 * A receiver is an object that performs a set of cohesive actions.
 * It’s the component that performs the actual action when the command’s execute() method is called.
 */
public class TextFile {

    private final String name;

    public TextFile(final String name) {
        this.name = name;
    }

    public String open() {
        return "Opening file " + name;
    }

    public String read() {
        return "Reading file " + name;
    }

    public String write() {
        return "Writing to file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }

    public String copy() {
        return "Copying file " + name;
    }

    public String paste() {
        return "Pasting file " + name;
    }
}
