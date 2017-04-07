package com.jurik99.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.jurik99.messenger.model.ErrorMessage;

/**
 * This mapper has a role "catch all" - no matter what exception is thrown, it catches them
 * We want to use "WebApplicationException" - that's why we don't need "@Provider"
 */
// @Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>
{
	@Override
	public Response toResponse(final Throwable exception)
	{
		final ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "www.jurik99.com");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}
}