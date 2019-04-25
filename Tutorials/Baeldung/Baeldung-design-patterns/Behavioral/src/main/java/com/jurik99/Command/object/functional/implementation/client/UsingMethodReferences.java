package com.jurik99.Command.object.functional.implementation.client;

import com.jurik99.Command.object.functional.implementation.invoker.TextFileOperationExecutor;
import com.jurik99.Command.object.functional.implementation.receiver.TextFile;

@SuppressWarnings("DanglingJavadoc")
public class UsingMethodReferences {

    public static void main(final String[] args) {

        final TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        final TextFile textFile = new TextFile("file1.txt");

        System.out.println(textFileOperationExecutor.executeOperation(textFile::open));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::save));

        /**
         * In this case, the implementation is a little bit more verbose than the one that uses lambdas,
         * as we still had to create the {@link TextFile} instances.
         */
    }
}
