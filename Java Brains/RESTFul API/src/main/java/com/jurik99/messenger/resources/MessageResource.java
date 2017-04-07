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
import static com.jurik99.messenger.helpers.MessageResourceHelper.getPathToMessageLink;

import com.jurik99.messenger.helpers.LinkReferences;
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
	public List<Message> getMessages(@BeanParam final MessageFilterBean filterBean)
	{
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
	* USING RESPOSNE INSTEAD OF RETURNING SIMPLE "MESSAGE" OBJECT
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

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") final long messageId, @Context UriInfo uriInfo)
	{
		final Message message = messageService.getMessage(messageId);

		final String path = getPathToMessageLink(uriInfo, messageId);
		final Link link = createLink(path, LinkReferences.SELF.getName());
		message.getLinks().add(link);

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
