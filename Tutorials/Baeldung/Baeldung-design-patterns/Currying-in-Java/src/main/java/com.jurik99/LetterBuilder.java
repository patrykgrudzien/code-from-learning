package com.jurik99;

import java.time.LocalDate;

public class LetterBuilder {

    private String returningAddress;
    private String insideAddress;
    private LocalDate dateOfLetter;
    private String salutation;
    private String body;
    private String closing;

    private LetterBuilder(final String returningAddress, final String insideAddress, final LocalDate dateOfLetter,
                          final String salutation, final String body, final String closing) {
        this.returningAddress = returningAddress;
        this.insideAddress = insideAddress;
        this.dateOfLetter = dateOfLetter;
        this.salutation = salutation;
        this.body = body;
        this.closing = closing;
    }

    /**
     * 4. (Builder Pattern)
     *
     * To overcome the unfriendly type definition and the repeated usage of the standard apply method,
     * meaning you have no clues about the correct order of inputs, we can use the builder pattern:
     */
    private static AddReturningAddress builder() {
        return returnAddress -> insideAddress -> dateOfLetter -> salutation -> body -> closing ->
                new LetterBuilder(returnAddress, insideAddress, dateOfLetter, salutation, body, closing);
    }

    /**
     * Instead of a sequence of functions, we use a sequence of functional interfaces.
     * Notice that the returning type of the above definition is AddReturnAddress.
     * In the following we have only to define the intermediate interfaces:
     */

    private interface AddReturningAddress {
        LetterBuilder.AddInsideAddress withReturningAddress(final String returningAddress);
    }

    private interface AddInsideAddress {
        LetterBuilder.AddDateOfLetter withInsideAddress(final String insideAddress);
    }

    private interface AddDateOfLetter {
        LetterBuilder.AddSalutation withDateOfLetter(final LocalDate dateOfLetter);
    }

    private interface AddSalutation {
        LetterBuilder.AddBody withSalutation(final String salutation);
    }

    private interface AddBody {
        LetterBuilder.AddClosing withBody(final String body);
    }

    private interface AddClosing {
        LetterBuilder withClosing(final String closing);
    }



    public static void main(String[] args) {

        // Notice that the interfaces ensure the filling order. So, we can’t just pre-fill closing !!!
        final LetterBuilder letterBuilder = LetterBuilder.builder()
                                                         .withReturningAddress("RETURNING_ADDRESS")
                                                         .withInsideAddress("INSIDE_ADDRESS")
                                                         .withDateOfLetter(LocalDate.now())
                                                         .withSalutation("SALUTATION")
                                                         .withBody("BODY")
                                                         .withClosing("CLOSING");
        System.out.println("Finished");
    }
}