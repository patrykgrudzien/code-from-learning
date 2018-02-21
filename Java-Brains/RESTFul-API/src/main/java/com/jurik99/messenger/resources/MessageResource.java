package com.jurik99.messenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.jurik99.messenger.helpers.LinkHelper.createLink;
import static com.jurik99.messenger.helpers.LinkHelper.createLinkUri;
import static com.jurik99.messenger.helpers.LinkHelper.createLinkUriForSubResource;
import static com.jurik99.messenger.helpers.LinkReferences.COMMENTS;
import static com.jurik99.messenger.helpers.LinkReferences.PROFILE;
import static com.jurik99.messenger.helpers.LinkReferences.SELF;
import static com.jurik99.messenger.resources.Constants.GET_COMMENT_RESOURCE;

import com.jurik99.messenger.model.Link;
import com.jurik99.messenger.model.Message;
import com.jurik99.messenger.resources.beans.MessageFilterBean;
import com.jurik99.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource
{
	private MessageService messageService = new MessageService();

	@GET
	public List<Message> getJSONMessages(@BeanParam final MessageFilterBean filterBean)
	{
		System.out.println("JSON method called.");
		if (filterBean.getYear() > 0)
		{
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0)
		{
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@GET
	@Produces(MediaType.TEXT_XML)   // @Produces - "Accept" Header
	public List<Message> getXMLMessages(@BeanParam final MessageFilterBean filterBean)
	{
		System.out.println("XML method called.");
		if (filterBean.getYear() > 0)
		{
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0)
		{
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	/*
	* USING RESPONSE INSTEAD OF RETURNING SIMPLE "MESSAGE" OBJECT
	*/
	@POST
	public Response addMessage(final Message message, @Context final UriInfo uriInfo) throws URISyntaxException
	{
		final Message newMessage = messageService.addMessage(message);

		final URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();

		return Response.created(uri).entity(newMessage).build();
		// return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") final long messageId, final Message message)
	{
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") final long messageId)
	{
		messageService.removeMessage(messageId);
	}

	@SuppressWarnings("Duplicates")
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") final long messageId, @Context final UriInfo uriInfo)
	{
		final Message message = messageService.getMessage(messageId);

		final String selfUri = createLinkUri(uriInfo, MessageResource.class, messageId);
		final String profileUri = createLinkUri(uriInfo, ProfileResource.class, message.getAuthor());
		final String commentsUri = createLinkUriForSubResource(uriInfo, MessageResource.class, GET_COMMENT_RESOURCE,
				CommentResource.class, "messageId", messageId);

		final Link selfLink = createLink(selfUri, SELF.getReference());
		final Link profileLink = createLink(profileUri, PROFILE.getReference());
		final Link commentsLink = createLink(commentsUri, COMMENTS.getReference());

		message.addLinks(selfLink, profileLink, commentsLink);

		return message;
	}

	/*
	 * We want this method to call all possible HTTP methods (GET, POST, PUT, DELETE)
	 * That's why we don't specify e.g. @GET
	 */
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
