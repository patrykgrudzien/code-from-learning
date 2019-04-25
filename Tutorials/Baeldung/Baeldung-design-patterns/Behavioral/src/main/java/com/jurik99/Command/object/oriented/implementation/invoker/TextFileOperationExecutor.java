package com.jurik99.Command.object.oriented.implementation.invoker;

import com.jurik99.Command.object.oriented.implementation.command.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * An invoker is an object that knows how to execute a given command but doesn’t know how
 * the command has been implemented. It only knows the command’s interface.
 *
 * In some cases, the invoker also stores and queues commands, aside from executing them.
 * This is useful for implementing some additional features, such as macro recording or undo and redo functionality.
 *
 * In our example, it becomes evident that there must be an additional component responsible for
 * invoking the command objects and executing them through the commands’ execute() method.
 * This is exactly where the invoker class comes into play.
 */
public class TextFileOperationExecutor {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<TextFileOperation> operations = new ArrayList<>();

    public String executeOperation(final TextFileOperation textFileOperation) {
        operations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
