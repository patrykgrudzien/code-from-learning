package com.jurik99.Command.object.functional.implementation.invoker;

import com.jurik99.Command.object.functional.implementation.command.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<TextFileOperation> operations = new ArrayList<>();

    public String executeOperation(final TextFileOperation textFileOperation) {
        operations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
