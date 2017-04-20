package com.jurik99.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter
{
	@Override
	public void filter(final ContainerRequestContext requestContext)
			throws IOException
	{
		System.out.println("Request filter");
		System.out.println("Headers: " + requestContext.getHeaders());
	}

	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext)
			throws IOException
	{
		System.out.println("Response filter");
		System.out.println("Headers: " + responseContext.getHeaders());
	}
}
