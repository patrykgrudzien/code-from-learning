package com.jurik99;

import io.vavr.collection.Stream;
import io.vavr.control.Try;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class HandlingSuccess {

	@Test
	public void givenHttpClient_whenMakeACall_shouldReturnSuccess() {

		// given
		final Integer defaultChainedResult = 1;
		final String id = "a";
		final HttpClient httpClient = () -> new Response(id);

		// when
		final Try<Response> response = Try.of(httpClient::call);
		Integer result = response.map(this::actionThatTakesResponse)
		                         .getOrElse(defaultChainedResult);
		/**
		 * If Try has a Success inside it, it returns value of Try, otherwise, it returns defaultChainedResult.
		 * Our httpClient execution was successful thus the isSuccess method returns true.
		 * Then we can execute onSuccess() method that makes an action on a Response object.
		 * Try has also a method andThen that takes a Consumer that consume a value of a Try when that value is a Success.
		 *
		 * We can treat our Try response as a stream. To do so we need to convert it to a Stream using toStream() method,
		 * then all operations that are available in Stream class could be used to make operations on that result.
		 */

		final Stream<String> stream = response.toStream().map(Response::getId);

		// then
		assertTrue(!stream.isEmpty());
		assertTrue(response.isSuccess());

		response.onSuccess(r -> assertEquals(id, r.getId()));
		response.andThen(r -> assertEquals(id, r.getId()));

		// NOT equals
		assertNotEquals(defaultChainedResult, result);

		System.out.println(actionThatTakesTryResponse(response, defaultChainedResult));
	}

	private int actionThatTakesResponse(final Response response) {
		return response.getId().hashCode();
	}

	/**
	 * If we want to execute an action on "Try" type, we can use "transform()" method that takes "Try" as an argument and make an action on it
	 * without unwrapping enclosed value.
	 */
	private int actionThatTakesTryResponse(final Try<Response> tryResponse, final int defaultTransformation) {
		return tryResponse.transform(response -> response.map(r -> r.getId().hashCode()))
		                  .getOrElse(defaultTransformation);
	}
}
