package com.jurik99;

import java.util.Arrays;

public class StreamReduceWithAccumulator {

    public static void main(String[] args) {

        /*
         * Stream reduce() performs a reduction on the elements of the stream. It uses identity and accumulator function for reduction.
         * In parallel processing we can pass combiner function as additional parameter to this method.
         * Stream reduce() can be used to get the sum of numbers stored in collection.
         * It can also concatenate the string data stored in collection with given separator.
         * Stream reduce() method can perform many more reducing task as required.
         */

        // Here we'll pass (BinaryOperator) as accumulator. In case of numeric (BinaryOperator), the start value will be 0.
        // In case of String, the start value will be a blank String.
        final int[] array = {23, 43, 56, 97, 32};

        Arrays.stream(array)
              .reduce((x, y) -> x + y)
              .ifPresent(System.out::println);

        Arrays.stream(array)
              .reduce(Integer::sum)
              .ifPresent(System.out::println);

        Arrays.stream(array)
              .reduce(StatisticsUtility::addIntData)
              .ifPresent(System.out::println);
    }
}

class StatisticsUtility {

    static int addIntData(int num1, int num2) {
        return num1 + num2;
    }
}
