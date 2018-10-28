package com.jurik99;

import io.vavr.control.Try;

public class HandlingExceptionsWithTry {

	private HttpClient httpClient = () -> new Response("123");

	/**
	 * Standard approach.
	 */
	public Response getResponseStandardApproach() {
		try {
			return httpClient.call();
		} catch (ClientException e) {
			return null;
		}
	}

	/**
	 * When we want to create API that is fluent and is written functionally, each method that throws checked exceptions disrupts program flow,
	 * and our program code consists of many try-catch blocks making it very hard to read.
	 *
	 * Ideally, we will want to have a special class that encapsulates result state ( success or a failure ),
	 * and then we can chain operations according to that result.
	 *
	 * The important thing to notice is a return type Try<Response>. When a method returns such result type, we need to handle that properly and keep in mind,
	 * that result type can be Success or Failure, so we need to handle that explicitly at a compile time.
	 */
	public Try<Response> getResponseUsingVavrTry() {
		return Try.of(httpClient::call);
	}
}
