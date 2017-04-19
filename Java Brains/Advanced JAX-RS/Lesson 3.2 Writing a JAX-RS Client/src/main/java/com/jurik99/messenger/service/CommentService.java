package com.jurik99.messenger.service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jurik99.messenger.database.DatabaseClass;
import com.jurik99.messenger.model.Comment;
import com.jurik99.messenger.model.ErrorMessage;
import com.jurik99.messenger.model.Message;

public class CommentService
{
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(final long messageId)
	{
		final Map<Long, Comment> comments = getCommentsMap(messageId);
		return new ArrayList<>(comments.values());
	}

	public Comment getComment(final long messageId, final long commentId)
	{
		final Message message = messages.get(messageId);

		/**
		 * This approach is quiet not so "elegant" because in service it should be only "business code",
		 * but we create here "errorMessage", "response" which should not be included in "sevice layer"
		 */
		final ErrorMessage webAppExceptionErrorMessage = new ErrorMessage("Message has not been found", 404,
		                                                                  "wwww.ERROR.comment.pl");
		final Response webAppExceptionResponse = Response.status(Response.Status.NOT_FOUND).entity(
				webAppExceptionErrorMessage).build();

		final ErrorMessage notFoundExceptionErrorMessage = new ErrorMessage("Comment has not been found", 404,
		                                                                    "wwww.ERROR.comment.pl");
		final Response notFoundExceptionResponse = Response.status(Response.Status.NOT_FOUND).entity(
				notFoundExceptionErrorMessage).build();

		if (message == null)
		{
			// --- WebApplicationException is a parent class of other more specific exceptions ---
			throw new WebApplicationException(webAppExceptionResponse);
		}

		final Map<Long, Comment> comments = message.getComments();

		final Comment comment = comments.get(commentId);
		if (comment == null)
		{
			// --- More specific exception ---
			throw new NotFoundException(notFoundExceptionResponse);
		}

		return comment;
	}

	public Comment addComment(final long messageId, final Comment comment)
	{
		final Map<Long, Comment> comments = getCommentsMap(messageId);
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(final long messageId, final Comment comment)
	{
		final Map<Long, Comment> comments = getCommentsMap(messageId);
		if (comment.getId() <= 0)
		{
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(final long messageId, final long commentId)
	{
		final Map<Long, Comment> comments = getCommentsMap(messageId);
		return comments.remove(commentId);
	}

	/**
	 * Get all comments for specified Message
	 */
	private Map<Long, Comment> getCommentsMap(final long messageId)
	{
		return new HashMap<>(messages.get(messageId).getComments());
	}
}
