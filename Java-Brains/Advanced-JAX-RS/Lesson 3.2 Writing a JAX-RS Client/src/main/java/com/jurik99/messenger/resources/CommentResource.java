package com.jurik99.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import com.jurik99.messenger.model.Comment;
import com.jurik99.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource
{
	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") final long messageId)
	{
		return commentService.getAllComments(messageId);
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") final long messageId,
	                          @PathParam("commentId") final long commentId)
	{
		return commentService.getComment(messageId, commentId);
	}

	@POST
	public Comment addComment(@PathParam("messageId") final long messageId, final Comment comment)
	{
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") final long messageId,
	                             @PathParam("commentId") final long commentId, final Comment comment)
	{
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") final long messageId,
	                             @PathParam("commentId") final long commentId)
	{
		return commentService.removeComment(messageId, commentId);
	}
}
