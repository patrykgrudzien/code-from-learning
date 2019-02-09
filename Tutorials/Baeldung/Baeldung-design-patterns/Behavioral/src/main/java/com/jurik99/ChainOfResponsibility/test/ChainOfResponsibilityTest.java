package com.jurik99.ChainOfResponsibility.test;

import org.junit.Test;

import com.jurik99.ChainOfResponsibility.AuthenticationProcessor;
import com.jurik99.ChainOfResponsibility.OAuthAuthenticationProcessor;
import com.jurik99.ChainOfResponsibility.OAuthTokenProvider;
import com.jurik99.ChainOfResponsibility.SamlAuthenticationProvider;
import com.jurik99.ChainOfResponsibility.UsernamePasswordAuthenticationProcessor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChainOfResponsibilityTest {

    /**
     * ==== Implementation Principles ====
     * We need to keep few important principles in mind while implementing Chain of Responsibility:
     *
     * 1) Each processor in the chain will have its implementation for processing a command
     * In our example above, all processors have their implementation of isAuthorized
     *
     * 2) Every processor in the chain should have reference to the next processor
     * Above, UsernamePasswordProcessor delegates to OAuthProcessor
     *
     * 3) Each processor is responsible for delegating to the next processor so beware of dropped commands
     * Again in our example, if the command is an instance of SamlProvider then the request may not get processed and will be unauthorized
     *
     * 4) Processors should not form a recursive cycle
     * In our example, we don’t have a cycle in our chain: UsernamePasswordProcessor -> OAuthProcessor.
     * But, if we explicitly set UsernamePasswordProcessor as next processor of OAuthProcessor,
     * then we end up with a cycle in our chain: UsernamePasswordProcessor -> OAuthProcessor -> UsernamePasswordProcessor.
     * Taking the next processor in the constructor can help with this
     *
     * 5) Only one processor in the chain handles a given command
     * In our example, if an incoming command contains an instance of OAuthTokenProvider, then only OAuthProcessor will handle the command
     */

    private static AuthenticationProcessor getChainOfAuthProcessor() {
        final AuthenticationProcessor oAuthProcessor = new OAuthAuthenticationProcessor(null);
        return new UsernamePasswordAuthenticationProcessor(oAuthProcessor);
    }

    @Test
    public void givenOAuthProvider_whenCheckingAuthorized_thenSuccess() {
        final AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        assertTrue(authProcessorChain.isAuthorized(new OAuthTokenProvider()));
    }

    @Test
    public void givenSamlProvider_whenCheckingAuthorized_thenSuccess() {
        final AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        assertFalse(authProcessorChain.isAuthorized(new SamlAuthenticationProvider()));
    }
}
