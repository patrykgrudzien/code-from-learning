package com.jurik99.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.jurik99.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>
{
	@Override
	public Response toResponse(final Throwable exception)
	{
		final ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "www.jurik99.com");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}
}