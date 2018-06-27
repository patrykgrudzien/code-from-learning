package com.jurik99.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static com.jurik99.rest.webTarget.MyWebTarget.ANY_MESSAGE_ID;
import static com.jurik99.rest.webTarget.MyWebTarget.MESSAGES;
import static com.jurik99.rest.webTarget.MyWebTarget.WEBAPI_CONTEXT;

import com.jurik99.messenger.model.Message;

public class RestApiClient
{
	public static void main(final String[] args)
	{
		// --- Client is something that we initialize ONLY ONCE per application ---
		final Client client = ClientBuilder.newClient();

		// --- Create WebTarget instead of hardcoded String ---
		final WebTarget baseTarget = client.target(WEBAPI_CONTEXT);

		// --- path() method already ADDS slash '/' to URL ---
		final WebTarget messagesTarget = baseTarget.path(MESSAGES);

		// --- Generic web target for any messageId ---
		final WebTarget singleMessageTarget = messagesTarget.path("{" + ANY_MESSAGE_ID + "}");

		final WebTarget target = client.target("http://localhost:8080/lesson-3-2/webapi/messages/1");
		final Builder builder = target.request(MediaType.APPLICATION_JSON);
		final Message message = builder.get(Message.class);

		/*
		 * We can specify what instance will be returned in get() method without using readEntity()
		 *
		 * final Message message = response.readEntity(Message.class);
		 */
		System.out.println(message.getMessage() + ", author: " + message.getAuthor());

		/*
		 * To avoid some problems with marshalling / unmarshalling sometimes safer approach is to get(String.class)
		 * and it returns whole page load (very handy during debugging)
		 */
		final String stringMessage = singleMessageTarget.resolveTemplate(ANY_MESSAGE_ID, 5)
		                                                .request(MediaType.APPLICATION_JSON)
		                                                .get(String.class);

		System.out.println(stringMessage);
	}
}
