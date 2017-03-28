package com.jurik99.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.jurik99.messenger.database.DatabaseClass;
import com.jurik99.messenger.exception.DataNotFoundException;
import com.jurik99.messenger.model.Message;

public class MessageService
{
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService()
	{
		messages.put(1L, new Message(1L, "Hello World!", "Patryk"));
		messages.put(2L, new Message(2L, "Hello Jersey!", "JuRik99"));
		messages.put(3L, new Message(3L, "Hello!", "Global"));
		messages.put(4L, new Message(4L, "Hello 4 message!", "Global 4"));
		messages.put(5L, new Message(5L, "Hello 5 message!", "Global 5"));
	}

	public List<Message> getAllMessages()
	{
		return new ArrayList<>(messages.values());
	}

	public List<Message> getAllMessagesForYear(final int year)
	{
		final List<Message> messagesForYear = new ArrayList<>();
		final Calendar cal = Calendar.getInstance();

		for (final Message message : messages.values())
		{
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year)
			{
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(final int start, final int size)
	{
		final List<Message> list = new ArrayList<>(messages.values());

		if (start + size > list.size())
			return new ArrayList<>();

		return list.subList(start, start + size);
	}

	public Message getMessage(final long id)
	{
		final Message message = messages.get(id);

		if (message == null)
		{
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return message;
	}

	public Message addMessage(final Message message)
	{
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(final Message message)
	{
		if (message.getId() <= 0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public void removeMessage(final long id)
	{
		messages.remove(id);
	}
}
