package com.jurik99;

import java.util.Arrays;
import java.util.List;

public class StreamReduceWithIdentityAccumulatorAndCombiner {

    public static void main(String[] args) {

        /*
         * Here we will pass three arguments identity, accumulator and combiner in reduce() method.
         * The identity value must be an identity for the combiner function.
         * This method with three arguments is used in parallel processing.
         * Combiner works with parallel stream only, otherwise there is nothing to combine.
         */
        final List<Integer> list = Arrays.asList(5, 6, 7);
        final Integer reduce = list.parallelStream()
                                   .reduce(0, (s1, s2) -> s1 + s2, (x, y) -> x * y);
        System.out.println("reduce = " + reduce);
    }
}
