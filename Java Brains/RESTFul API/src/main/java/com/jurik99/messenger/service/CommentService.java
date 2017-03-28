package com.jurik99.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jurik99.messenger.database.DatabaseClass;
import com.jurik99.messenger.model.Comment;
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
		final Map<Long, Comment> comments = getCommentsMap(messageId);
		return comments.get(commentId);
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
