package com.jurik99.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedList;
import java.util.List;

public class SpyMockitoExample
{
	private static final Logger logger = Logger.getLogger(SpyMockitoExample.class);

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	/*
	 * @Spy or the "spy()" method can be used to wrap a REAL OBJECT. Every call, unless specified otherwise, is
	 * delegated to the object.
	 */
	@Test
	public void testLinkedListSpyWrong()
	{
		// --- Let's mock a LinkedList ---
		final List<String> list = new LinkedList<>();
		final List<String> spyList = spy(list);

		/*
		 * This does NOT work, real method is called so "spy.get(0)" throws IndexOutOfBoundsException
		 * (list is still empty)
		 */
		expectedException.expect(IndexOutOfBoundsException.class);
		System.out.println("ExpectedException threw IndexOutOfBoundException!");

		when(spyList.get(0)).thenReturn("foo");

		assertEquals("foo", spyList.get(0));
	}

	@Test
	public void testLinkedListSpyCorrect()
	{
		// --- Let's mock a LinkedList ---
		final List<String> list = new LinkedList<>();
		final List<String> spyList = spy(list);

		// --- You have to use "doReturn()" for stubbing ---
		doReturn("foo").when(spyList).get(0);

		assertEquals("foo", spyList.get(0));
		logger.info("Expected = actual. spyList.get(0): " + spyList.get(0));
	}
}
