package com.jurik99.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*
 * The {pathParam} in the Path annotation lets you map resource to a variable path pattern.
 *
 * @Singleton will cause VALIDATION ERROR.
 *
 * Singleton resources are instantiated during application startup. So it is impossible to inject request-specific
 * information to their member variables !!!
 *
 * Resource is created BEFORE request comes in !!!
 */
@Path("{pathParam}/test")
public class MyResource
{
	@PathParam("pathParam")
	private String pathParamExample;

	@QueryParam("query")
	private String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod()
	{
		return "It works! Path param used: " + pathParamExample + " and Query param used: " + queryParamExample;
	}
}
