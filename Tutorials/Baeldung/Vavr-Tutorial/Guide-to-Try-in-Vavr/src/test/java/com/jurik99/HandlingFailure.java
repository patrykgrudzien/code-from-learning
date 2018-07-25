package com.jurik99;

import io.vavr.control.Option;
import io.vavr.control.Try;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HandlingFailure {

	@Test
	public void givenHttpClientFailure_whenMakeACall_shouldReturnFailure() {

		// given
		final Integer defaultChainedResult = 1;
		final HttpClient httpClient = () -> {
			throw new ClientException("Problem");
		};

		// when
		Try<Response> response = Try.of(httpClient::call);
		final Integer chainedResult = response.map(this::actionThatTakesResponse)
		                                      .getOrElse(defaultChainedResult);
		final Option<Response> optionalResponse = response.toOption();

		// then
		assertTrue(optionalResponse.isEmpty());
		assertTrue(response.isFailure());
		response.onFailure(exception -> assertTrue(exception instanceof ClientException));
		assertEquals(defaultChainedResult, chainedResult);

		/**
		 * The "Try.of(httpClient::call)" returns Failure thus method isFailure returns true.
		 *
		 * We could execute the onFailure() callback on returned response and see that exception is of ClientException type.
		 * The object that is of a Try type could be mapped to Option type using toOption() method.
		 *
		 * It is useful when we do not want to carry our Try result throughout all codebase, but we have methods that are handling an explicit absence of value using
		 * Option type. When we map our Failure to Option, then method isEmpty() is returning true. When Try object is a type Success calling toOption on it will make
		 * Option that is defined thus method isDefined() will return true.
		 */
	}

	private int actionThatTakesResponse(final Response response) {
		return response.getId().hashCode();
	}
}
