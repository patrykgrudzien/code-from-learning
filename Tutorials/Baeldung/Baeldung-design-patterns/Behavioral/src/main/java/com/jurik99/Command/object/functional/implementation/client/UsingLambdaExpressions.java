package com.jurik99.Command.object.functional.implementation.client;

import com.jurik99.Command.object.functional.implementation.invoker.TextFileOperationExecutor;

@SuppressWarnings("DanglingJavadoc")
public class UsingLambdaExpressions {

    public static void main(final String[] args) {

        final TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

        /**
         * As the TextFileOperation interface is a functional interface, we can pass command objects in the form of
         * lambda expressions to the invoker, without having to create the TextFileOperation instances explicitly:
         */
        System.out.println(textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt"));
        System.out.println(textFileOperationExecutor.executeOperation(() -> "Saving file file1.txt"));

        /**
         * The implementation now looks much more streamlined and concise, as we’ve reduced the amount of boilerplate code.
         *
         * Even so, the question still stands: is this approach better, compared to the object-oriented one?
         *
         * Well, that’s tricky. If we assume that more compact code means better code in most cases, then indeed it is.
         *
         * As a rule of thumb, we should evaluate on a per-use-case basis when to resort to lambda expressions.
         */
    }
}
