package com.jurik99.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/date/{dateString}")
public class DateResource
{
	/*
	 * Jersey does not know how to convert from STRING to "MyDate"
	 *
	 * We need:
	 * 1) ParamconverterProvider
	 * 2) ParamConverter<T>
	 */
	@SuppressWarnings("RestParamTypeInspection")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateString") final MyDate myDate)
	{
		return "Got " + myDate.toString();
	}
}
