package com.jurik99.filters;

import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter
{
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secured";
	private static final String CORRECT_USER_NAME = "username";
	private static final String CORRECT_PASSWORD = "password";
	private static final int FIRST = 0;

	@Override
	public void filter(final ContainerRequestContext requestContext)
			throws IOException
	{
		final List<String> allAuthorizationHeaders = requestContext.getHeaders().get(AUTHORIZATION_HEADER);

		/*
		 * Basic Auth (Basic Access Authentication)
		 * In the HEADER we have (username + password)
		 *
		 * Basic auth - client side
		 * username:password  ->  Base64 encoding  ->  dXNlcm5hbWU6cGFzc3dvcmQ=
		 * In the header "Authorization" we set value to: "Basic dXNlcm5hbWU6cGFzc3dvcmQ="
		 * (Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=)
		 *
		 * Then we encode and use StringTokenizer in the code below to decodeAsString();
		 *
		 * Security is not the intent of the encoding step. Rather, the intent of the encoding is to ENCODE
		 * "non-HTTP-compatible" CHARACTERS that may be in the user name or password into those that are
		 * "HTTP-compatible"
		 */
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX))
		{
			if (allAuthorizationHeaders != null && allAuthorizationHeaders.size() > 0)
			{
				String authToken = allAuthorizationHeaders.get(FIRST);  // Basic dXNlcm5hbWU6cGFzc3dvcmQ=
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");    // dXNlcm5hbWU6cGFzc3dvcmQ=
				final String decodedString = Base64.decodeAsString(authToken);  // username:password

				final StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");

				final String userName = tokenizer.nextToken();  // username
				final String password = tokenizer.nextToken();  // password

				if (userName.equals(CORRECT_USER_NAME) && password.equals(CORRECT_PASSWORD))
				{
					// --- If we return from filter(), it means that JAX-RS is free to proceed with actual request ---
					return;
				}
			}
			final Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED)
			                                              .entity("User cannot access the resource.").build();

			// --- abortWith() lets abort the request from filter ---
			requestContext.abortWith(unauthorizedResponse);
		}
	}
}
