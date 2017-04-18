package com.jurik99.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

/*
 * We have to also annotate this Provider what kind of MediaType it can handle.
 */
@Provider
@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWriter implements MessageBodyWriter<Date>
{
	@Override
	public long getSize(final Date date, final Class<?> aClass, final Type type, final Annotation[] annotations,
	                    final MediaType mediaType)
	{
		/*
		 * According to tutorial this method is currently deprecated (there is also such info in documentation)
		 * We don't want to implement this method .
		 *
		 * Recomended best practise is to simply return -1.
		 */
		return -1;
	}

	@Override
	public boolean isWriteable(final Class<?> type, final Type type1, final Annotation[] annotations,
	                           final MediaType mediaType)
	{
		/*
		 * Implementation of this method lets Jersey know if our specified type <T> can be handled by writer
		 *
		 * FIRST APPROACH (OWN)
		 * return type.getClass().getName().equals(Date.class.getName());
		 */

		// --- Other approach ---
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(final Date date, final Class<?> type, final Type type1, final Annotation[] annotations,
	                    final MediaType mediaType, final MultivaluedMap<String, Object> multivaluedMap,
	                    final OutputStream outputStream)
			throws IOException, WebApplicationException
	{
		outputStream.write(date.toString().getBytes());
	}
}
