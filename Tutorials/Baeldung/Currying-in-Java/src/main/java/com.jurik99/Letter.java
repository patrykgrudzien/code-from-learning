package com.jurik99;

import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("SameParameterValue")
public class Letter {

    private String salutation;
    private String body;

    private Letter(final String salutation, final String body) {
        this.salutation = salutation;
        this.body = body;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getBody() {
        return body;
    }

    /**
     * 2.1. (Creation by Method)
     */
    private static Letter createLetter(final String salutation, final String body) {
        return new Letter(salutation, body);
    }

    /**
     * 2.2. (Creation with a "BiFunction")
     *
     * The above method works just fine, but we may need to supply this behavior
     * to something written in the functional style. Since Java 8, we can use BiFunction for this purpose:
     */
    private static BiFunction<String, String, Letter> SIMPLE_LETTER_CREATOR = Letter::new;

    /**
     * 2.3. (Creation with a Sequence of Functions)
     *
     * We see that salutation maps to a function. The resulting function maps onto the
     * new Letter object. See how the return type has changed from BiFunction.
     * We’re only using the Function class. Such a transformation to a sequence of functions is called currying.
     */
    private static Function<String, Function<String, Letter>> SIMPLE_CURRIED_LETTER_CREATOR =
            salutation -> body -> new Letter(salutation, body);




    public static void main(String[] args) {

        final Letter letter1 = createLetter("salutation", "body");

        final Letter letter2 = SIMPLE_LETTER_CREATOR.apply("salutation", "body");

        final Letter letter3 = SIMPLE_CURRIED_LETTER_CREATOR.apply("salutation")
                                                            .apply("body");

        System.out.println("Finished");
    }
}
