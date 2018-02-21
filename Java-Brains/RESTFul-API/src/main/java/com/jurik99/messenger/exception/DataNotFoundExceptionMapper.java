package com.jurik99.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.jurik99.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{
	/*
	 * The way we map exceptions to responses in JAX-RS is to use ExceptionMapper
	 * We have to annotate our class with @Provider (it registeres that class in JAX-RS) !!!
	 * It is equal to define in other frameworks class in xml
	 */
	@Override
	public Response toResponse(final DataNotFoundException exception)
	{
		final ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "www.jurik99.com");
		return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
	}
}
