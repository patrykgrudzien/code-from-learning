package com.jurik99;

import java.util.Arrays;

public class StreamReduceWithIdentityAndAccumulator {

    public static void main(String[] args) {

        // Here we'll use an identity and accumulator. We'll pass the identity as start value.
        final int[] array = {23, 43, 56, 97, 32};
        // Set start value. Result will be start value + sum of array.
        int startValue = 100;

        final int sum = Arrays.stream(array)
                              .reduce(startValue, (x, y) -> x + y);
        System.out.println("sum = " + sum);

        final int reduceWithMethodReference = Arrays.stream(array)
                                                    .reduce(startValue, Integer::sum);
        System.out.println("reduceWithMethodReference = " + reduceWithMethodReference);
    }
}
