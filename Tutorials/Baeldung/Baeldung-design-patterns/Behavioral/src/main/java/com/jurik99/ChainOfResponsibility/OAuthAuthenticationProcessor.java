package com.jurik99.ChainOfResponsibility;

public class OAuthAuthenticationProcessor extends AuthenticationProcessor {

    public OAuthAuthenticationProcessor(final AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(final AuthenticationProvider authProvider) {
        if (authProvider instanceof OAuthTokenProvider) {
            return Boolean.TRUE;
        } else if (getNextProcessor() != null) {
            return getNextProcessor().isAuthorized(authProvider);
        } else {
            return Boolean.FALSE;
        }
    }
}
