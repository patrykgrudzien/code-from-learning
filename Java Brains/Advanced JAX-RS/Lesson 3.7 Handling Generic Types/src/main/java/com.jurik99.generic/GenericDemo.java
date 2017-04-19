package com.jurik99.generic;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import com.jurik99.messenger.model.Message;

public class GenericDemo
{
	public static void main(String[] args)
	{
		final Client client = ClientBuilder.newClient();

		final Response response = client.target("http://localhost:8080/lesson-3-2/webapi/")
		                                .path("messages")
		                                .queryParam("year", 2017)
		                                .request(MediaType.APPLICATION_JSON)
		                                .get();
//								    	.get(List.class); -> ERROR !!!
		/*
		 * We have problem here because JAX-RS does not know what generic type is inside of that List<E>.
		 * System.out.println(response); prints Exception that we need "MessageBodyWriter".
		 *
		 * org.glassfish.jersey.message.internal.MessageBodyProviderNotFoundException: MessageBodyReader not found for
		 * media type=application/json, type=interface java.util.List, genericType=interface java.util.List
		 */

		// --- get() method has some special signiture -> get(GenericType<T> genericType) ---
		final List<Message> listResponse = client.target("http://localhost:8080/lesson-3-2/webapi/")
		                                         .path("messages")
		                                         .request(MediaType.APPLICATION_JSON)
		                                         .get(new GenericType<List<Message>>() {});

		listResponse.forEach(System.out::println);
	}
}
