package com.jurik99;

import io.vavr.API;
import io.vavr.CheckedFunction1;
import io.vavr.Value;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("DanglingJavadoc")
public class Example {

    public static void main(String[] args) {

        /**
         * =====================================
         * ====== Using "CheckedFunction" ======
         * =====================================
         */
        // we can use the below method inside a lambda expression without handling the "IOException"
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);

        CheckedFunction1<Integer, Integer> readFunction = Example::readFromFile;

        // omitting handling an Exception
        integers.stream().map(readFunction.unchecked());

        final Stream<Integer> integerStream = integers.stream().map(readFunction.unchecked());
//        final Optional<Integer> first = integerStream.findFirst();    // here (IOException) is thrown

        /*
         * As you can see, without the standard "try-catch" or the wrapper methods, we can still call exception
         * throwing methods inside a lambda expression.
         *
         * We must exercise caution while using this feature with the "Stream API", as an exception would
         * immediately terminate the operation - abandoning the rest of the stream.
         */

        /**
         * ====================================
         * ====== Using "Helper Methods" ======
         * ====================================
         */
        // The API class provides a shortcut method for the example above.
        integers.stream().map(API.unchecked(Example::readFromFile));

        /**
         * ===================================
         * ========= Using "Lifting" =========
         * ===================================
         * To handle an "IOException" gracefully, we can introduce standard "try-catch" blocks inside a lambda expression.
         * However, the conciseness of a lambda expression will be lost. Vavr’s lifting comes to our rescue.
         *
         * Lifting is a concept from functional programming. You can lift a partial function to a total function that
         * returns an Option as result.
         *
         * A partial function is a function that is defined only for a subset of a domain as opposed to a total function
         * which is defined for the entirety of its domain. If the partial function is called with input that is outside
         * of its supporting range, it will typically throw an exception.
         */
        Stream<Integer> liftStream = integers.stream()
                                             .map(CheckedFunction1.lift(Example::readFromFile))
                                             .map(optionOfInteger -> optionOfInteger.getOrElse(-1));
        liftStream.findFirst().ifPresent(System.out::println);  // -1 is printed

        // Note that result of the lifted function is "Option" and the result will be "Option.None" in case of an exception.
        // The method "getOrElse()" takes an alternate value to return in case of "Option.None".

        /**
         * ===================================
         * =========== Using "Try" ===========
         * ===================================
         * While the method lift() in the previous section solves the issue of abrupt program termination,
         * it actually swallows the exception. Consequently, the consumer of our method has no idea on what resulted
         * in the default value. The alternative is to use a Try container.
         *
         * Try is a special container with which we can enclose an operation that might possibly throw an exception.
         * In this case, the resulting Try object represents a Failure and it wraps the exception.
         *
         * Let’s look at the code that uses Try:
         */
        integers.stream()
                .map(CheckedFunction1.liftTry(Example::readFromFile))
                .flatMap(Value::toJavaStream)
                .forEach(System.out::println);
    }

    private static Integer readFromFile(final Integer integer) throws IOException {
        // logic to read from file which throws IOException
        throw new IOException("IOException thrown!");
    }
}
