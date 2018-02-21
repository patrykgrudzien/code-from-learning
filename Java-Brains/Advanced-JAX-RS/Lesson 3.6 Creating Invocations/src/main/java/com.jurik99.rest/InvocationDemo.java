package com.jurik99.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo
{
	public static void main(final String[] args)
	{
		final InvocationDemo invocationDemo = new InvocationDemo();

		final Invocation invocation = invocationDemo.prepareRequestForMessagesByYear(2016);
		final Response response = invocation.invoke();

		System.out.println(response.getStatus());
	}

	private Invocation prepareRequestForMessagesByYear(final int year)
	{
		final Client client = ClientBuilder.newClient();

		/*
		 * Typically we just would like to have - is GET Request in order to send that request.
		 * But we don't want to "get" request here, call that and have status etc...
		 * We just want to PREPARE it - that's why we use "buildGet()" instead of "get()" itself.
		 */
		return client.target("http://localhost:8080/lesson-3-2/webapi/")
		             .path("messages")
		             .queryParam("year", year)
		             .request(MediaType.APPLICATION_JSON)
		             .buildGet();
	}
}
