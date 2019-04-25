package com.jurik99.Command.object.oriented.implementation.command;

import com.jurik99.Command.object.oriented.implementation.receiver.TextFile;

public class OpenTextFileOperation extends TextFileOperation {

    public OpenTextFileOperation(final TextFile textFile) {
        super(textFile);
    }

    @Override
    public String execute() {
        return getTextFile().open();
    }
}
