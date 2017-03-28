package com.jurik99.messenger.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.List;

import com.jurik99.messenger.model.Message;

public class MessageServiceTest
{
	private MessageService messageService = new MessageService();

	@Test
	public void testGetAllMessages()
	{
		final List<Message> messages = messageService.getAllMessages();

		assertNotNull(messages);
		assertThat(messages.size(), is(5));
		assertThat(messages.size(), is(greaterThan(0)));
	}
}
