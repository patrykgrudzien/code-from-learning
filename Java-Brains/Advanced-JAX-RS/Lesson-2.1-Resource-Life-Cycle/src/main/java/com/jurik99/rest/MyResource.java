package com.jurik99.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Singleton  // ONE resource instance no matter how many times we make a request
public class MyResource
{
	private int count;

	/*
	 * Every time we make API request, JAX-RS creates new instance of MyResource class
	 * (it never shares the same instance) !!!
	 * EVERY REQUEST (RESULTS) -> NEW INSTANCE (this is default behavior of resources in JAX-RS)
	 * Scope = Request (by default)
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod()
	{
		count++;
		return "It works! This method was called " + count + " time(s)";
	}
}
