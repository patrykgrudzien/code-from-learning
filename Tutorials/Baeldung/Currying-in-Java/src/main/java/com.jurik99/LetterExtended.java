package com.jurik99;

import java.time.LocalDate;
import java.util.function.Function;

public class LetterExtended {

    /**
     * In order to show the advantages of currying, let’s extend our Letter class constructor with more parameters:
     */

    private String returningAddress;
    private String insideAddress;
    private LocalDate dateOfLetter;
    private String salutation;
    private String body;
    private String closing;

    private LetterExtended(final String returningAddress, final String insideAddress, final LocalDate dateOfLetter,
                           final String salutation, final String body, final String closing) {
        this.returningAddress = returningAddress;
        this.insideAddress = insideAddress;
        this.dateOfLetter = dateOfLetter;
        this.salutation = salutation;
        this.body = body;
        this.closing = closing;
    }

    /**
     * 3.1 (Creation by Method)
     */
    private static LetterExtended createLetter(final String returnAddress, final String insideAddress, final LocalDate dateOfLetter,
                                               final String salutation, final String body, final String closing) {
        return new LetterExtended(returnAddress, insideAddress, dateOfLetter, salutation, body, closing);
    }

    /**
     * 3.2. (Functions for Arbitrary Arity)
     *
     * Arity is a measure of the number of parameters a function takes.
     * Java provides existing functional interfaces for nullary (Supplier), unary (Function), and binary (BiFunction),
     * but that’s it. Without defining a new Functional Interface, we can’t provide a function with six input parameters.
     *
     * Currying is our way out. It transforms an arbitrary arity into a sequence of unary functions.
     * So for our example, we get:
     */
    private static Function<String, Function<String, Function<LocalDate, Function<String, Function<String, Function<String, LetterExtended>>>>>>
            LETTER_CREATOR =
            returnAddress -> insideAddress -> dateOfLetter -> salutation -> body -> closing -> new LetterExtended(
                    returnAddress, insideAddress, dateOfLetter, salutation, body, closing);

    /**
     * 3.4. (Pre-Filling Values)
     *
     * With this chain of functions, we can create a helper which pre-fills out the first values
     * and returns the function for onward completion of the letter object:
     *
     * Notice, that for this to be useful, we have to carefully choose the order of the parameters
     * in the original function so that the less specific are the first ones.
     */
    private static Function<String, Function<LocalDate, Function<String, Function<String, Function<String, LetterExtended>>>>>
            LETTER_CREATOR_PREFILLED = insideAddress -> LETTER_CREATOR.apply("RETURNING_ADDRESS").apply(insideAddress);




    public static void main(String[] args) {

        // 3.2. (Verbose Type) - Obviously, the above type is not quite readable. With this form, we use ‘apply’ six times to create a Letter:
        final LetterExtended letterExtended =
                LETTER_CREATOR
                        .apply("RETURNING_ADDRESS")
                        .apply("INSIDE_ADDRESS")
                        .apply(LocalDate.now())
                        .apply("SALUTATION")
                        .apply("BODY")
                        .apply("CLOSING");

        final LetterExtended letterExtended1 =
                LETTER_CREATOR_PREFILLED
                        .apply("INSIDE_ADDRESS")
                        .apply(LocalDate.now())
                        .apply("SALUTATION")
                        .apply("BODY")
                        .apply("CLOSING");

        System.out.println("Finished");
    }
}
