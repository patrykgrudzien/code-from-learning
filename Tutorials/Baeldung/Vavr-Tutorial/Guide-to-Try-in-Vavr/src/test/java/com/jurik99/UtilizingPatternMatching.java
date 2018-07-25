package com.jurik99;

import io.vavr.control.Try;

import org.junit.Test;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;
import static org.junit.Assert.assertTrue;

public class UtilizingPatternMatching {

	/**
	 * When our httpClient returns an Exception, we could do a pattern matching on a type of that Exception.
	 * Then according to a type of that Exception in recover() a method we can decide if we want to recover from that exception and turn our Failure into Success
	 * or if we want to leave our computation result as a Failure.
	 */
	@Test
	public void givenHttpClientThatFailure_whenMakeACall_shouldReturnFailureAndNotRecover() {

		// given
		final Response defaultResponse = new Response("default response");
		final HttpClient httpClient = () -> {
			throw new RuntimeException("critical runtime exception");
		};

		// when
		final Try<Response> recovered = Try.of(httpClient::call)
		                                   .recover(r -> Match(r).of(
		                                   		Case(Match.Pattern0.of(ClientException.class), defaultResponse),
			                                    // another syntax for the line above
			                                    Case($(instanceOf(RuntimeException.class)), new Response("caught runtime exception")))
		                                   );
		// then
		assertTrue(recovered.isSuccess());
	}
}
