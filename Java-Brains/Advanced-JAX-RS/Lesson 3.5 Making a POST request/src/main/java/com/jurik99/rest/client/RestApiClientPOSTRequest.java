package com.jurik99.rest.client;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static com.jurik99.rest.webTarget.MyWebTarget.MESSAGES;
import static com.jurik99.rest.webTarget.MyWebTarget.WEBAPI_CONTEXT;

import com.jurik99.messenger.model.Message;

@SuppressWarnings("Duplicates")
public class RestApiClientPOSTRequest
{
	public static void main(final String[] args)
	{
		// --- Client is something that we initialize ONLY ONCE per application ---
		final Client client = ClientBuilder.newClient();

		// --- Create WebTarget instead of hardcoded String ---
		final WebTarget baseTarget = client.target(WEBAPI_CONTEXT);

		// --- path() method already ADDS slash '/' to URL ---
		final WebTarget messagesTarget = baseTarget.path(MESSAGES);

		// --- Creating new Message instance to POST it using RestApiClientPOSTRequest ---
		final Message newMessage = new Message(6L, "My New message from JAX-RS Client", "JuRIk99");

		final Response postResponse = messagesTarget.request()
		                                            .post(Entity.json(newMessage));

		if (postResponse.getStatus() == CREATED.getStatusCode())
		{
			final Message createdMessage = postResponse.readEntity(Message.class);
			System.out.println(createdMessage.getMessage());
		}
		else
		{
			Response.status(INTERNAL_SERVER_ERROR)
			        .build();
			System.out.println("ERROR !!!");
		}

	}
}
