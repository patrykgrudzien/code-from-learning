package com.jurik99.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import java.io.IOException;

/*
--- INTRODUCTION ---
Filters and interceptors can be used on both sides, on the client and the server side.
Filters can modify inbound and outbound requests and responses including modification of headers, entity and
other request/response parameters.

--- FILTERS ---
Filters can be used when you want to modify any request or response parameters like headers.
For example you would like to add a response header "X-Powered-By" to each generated response.
Instead of adding this header in each resource method you would use a response filter to add this header.

There are filters on the server side and the client side.

--- INTERCEPTORS ---
Interceptors are used primarily for modification of entity input and output streams.
You can use interceptors for example to zip and unzip output and input entity streams.

--- Server filters: ---
ContainerRequestFilter
ContainerResponseFilter

--- Client filters: ---
ClientRequestFilter
ClientResponseFilter
*/

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter
{
	/*
	 * This filter is applicable to any REST API calls and there is no need to implement such functionality
	 * like adding header value to each resource method.
	 */
	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext)
			throws IOException
	{
		responseContext.getHeaders().add("X-Powered-By", "Java Brains");
	}
}
