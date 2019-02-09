package com.jurik99.Facade;

import org.apache.commons.lang3.StringUtils;

/**
 * Simply put, a facade encapsulates a complex subsystem behind a simple interface. It hides much of the complexity and makes the subsystem easy to use.
 *
 * Also, if we need to use the complex subsystem directly, we still can do that; we aren’t forced to use the facade all the time.
 *
 * Besides a much simpler interface, there’s one more benefit of using this design pattern.
 * It decouples a client implementation from the complex subsystem.
 * Thanks to this, we can make changes to the existing subsystem and don’t affect a client.
 */
public class Main {

    // Let’s say that we want to start a car
    public static void main(final String[] args) {

        final Facade facade = new Facade();

        facade.startEngine();
        System.out.println(StringUtils.repeat("-", 100));
        facade.stopEngine();

        /**
         * The facade pattern doesn’t force us to unwanted tradeoffs, because it only adds additional layers of abstraction.
         *
         * Sometimes the pattern can be overused in simple scenarios, which will lead to redundant implementations.
         */
    }
}
