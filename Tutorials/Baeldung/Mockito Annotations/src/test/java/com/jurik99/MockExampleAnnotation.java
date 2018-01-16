package com.jurik99;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockExampleAnnotation
{
	@Mock
	private List<String> mockedList;

	@Test
	public void whenUseMockAnnotationThenMockIsInjected()
	{
		mockedList.add("one");
		Mockito.verify(mockedList).add("one");
		assertEquals(0, mockedList.size());

		Mockito.when(mockedList.size()).thenReturn(100);
		assertEquals(100, mockedList.size());
	}
	/*
	 *  Note now - in both examples, we're interacting with the mock and verifying some of these interactions - just
	 *  to make sure that mock is behaving correctly.
	 */
}