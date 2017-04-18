package com.jurik99.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.Calendar;
import java.util.Date;

import com.jurik99.mediaType.CustomMediaType;

@Path("/test")
public class MyResource
{
	@GET
	@Produces(CustomMediaType.TEXT_SHORT_DATE)
	public Date testMethod()
	{
		return Calendar.getInstance().getTime();
	}

	/*
	 * Writers take JAVA OBJECT and convert them for specific MediaType e.g. text/plain. Methods return specific data
	  * type instead of simply String. WRITERS - @Produces
	  *
	  * Readers take from e.g. POST request xml or json (MediaType) representation of some object e.g. USER and
	  * return JAVA OBJECT. Method: public void getUser(final User user) {System.out.println(user);}
	  * READERS - @Consumes
	 */
}
