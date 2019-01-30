package com.jurik99;

import java.util.function.Function;

public class ComposingFunctions {

    public static void main(String[] args) {

        /*
         * In this post we're going to take a look at function composition using two compose functions provided in the Function interface - compose and andThen.
         *
         * What is function composition?
         * It all has to do with creating small reusable functions that you can combine to compose new functions.
         */
        final Function<Integer, Integer> times2 = num -> num * 2;
        final Function<Integer, Integer> squared = num -> num * num;

        /*
         * As you can see, the difference between compose and andThen is the order they execute the functions.
         * While the compose function executes the caller last and the parameter first, the andThen executes the caller first and the parameter last.
         */
        System.out.println("times2.compose(squared).apply(4) = " + times2.compose(squared).apply(4));   // returns 32
        System.out.println("times2.andThen(squared).apply(4) = " + times2.andThen(squared).apply(4));   // returns 64
    }
}
