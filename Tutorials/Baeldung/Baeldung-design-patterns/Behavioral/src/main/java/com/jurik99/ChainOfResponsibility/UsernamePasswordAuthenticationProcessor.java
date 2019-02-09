package com.jurik99.ChainOfResponsibility;

public class UsernamePasswordAuthenticationProcessor extends AuthenticationProcessor {

    public UsernamePasswordAuthenticationProcessor(final AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(final AuthenticationProvider authProvider) {
        if (authProvider instanceof UsernamePasswordProvider) {
            return Boolean.TRUE;
        } else if (getNextProcessor() != null) {
            return getNextProcessor().isAuthorized(authProvider);
        } else {
            return Boolean.FALSE;
        }
    }
}
