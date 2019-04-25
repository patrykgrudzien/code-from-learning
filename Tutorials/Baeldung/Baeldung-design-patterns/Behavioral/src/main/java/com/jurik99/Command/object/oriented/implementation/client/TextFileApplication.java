package com.jurik99.Command.object.oriented.implementation.client;

import com.jurik99.Command.object.oriented.implementation.command.OpenTextFileOperation;
import com.jurik99.Command.object.oriented.implementation.command.SaveTextFileOperation;
import com.jurik99.Command.object.oriented.implementation.command.TextFileOperation;
import com.jurik99.Command.object.oriented.implementation.invoker.TextFileOperationExecutor;
import com.jurik99.Command.object.oriented.implementation.receiver.TextFile;

public class TextFileApplication {

    public static void main(final String[] args) {

        final TextFileOperation openOperation = new OpenTextFileOperation(new TextFile("file1.txt"));
        final TextFileOperation saveOperation = new SaveTextFileOperation(new TextFile("file2.txt"));

        final TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        System.out.println(textFileOperationExecutor.executeOperation(openOperation));
        System.out.println(textFileOperationExecutor.executeOperation(saveOperation));
    }
}
