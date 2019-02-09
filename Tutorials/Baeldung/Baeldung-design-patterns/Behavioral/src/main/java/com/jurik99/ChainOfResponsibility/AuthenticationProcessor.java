package com.jurik99.ChainOfResponsibility;

public abstract class AuthenticationProcessor {

    // next element in chain or responsibility
    private final AuthenticationProcessor nextProcessor;

    AuthenticationProcessor(final AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    AuthenticationProcessor getNextProcessor() {
        return nextProcessor;
    }

    public abstract boolean isAuthorized(AuthenticationProvider authProvider);
}
