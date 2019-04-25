package com.jurik99.Command.object.oriented.implementation.command;

import com.jurik99.Command.object.oriented.implementation.receiver.TextFile;

/**
 * A command is an object whose role is to store all the information required for executing an action,
 * including the method to call, the method arguments, and the object (known as the receiver) that implements the method.
 *
 * To get a more accurate idea of how command objects work,
 * let’s start developing a simple command layer which includes just one single abstract class and two implementations:
 *
 * In this case, the {@link TextFileOperation} abstract class defines the command objects’ API, and the two implementations,
 * {@link OpenTextFileOperation} and {@link SaveTextFileOperation}, perform the concrete actions.
 *
 * It’s clear to see the functionality of a command object:
 * the {@link TextFileOperation} commands encapsulate all the information required for opening and saving a text file,
 * including the receiver object, the methods to call, and the arguments
 * (in this case, no arguments are required, but they could be).
 *
 * It’s worth stressing that the component that performs the file operations is
 * the receiver (the {@link TextFile} instance).
 */
public abstract class TextFileOperation {

    // receiver
    private final TextFile textFile;

    TextFileOperation(final TextFile textFile) {
        this.textFile = textFile;
    }

    TextFile getTextFile() {
        return textFile;
    }

    public abstract String execute();
}
