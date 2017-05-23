package com.jurik99;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockExample
{
	/*
	 * The most widely used annotation in Mockito is "@Mock". We can use @Mock to create and inject mocked instances
	 * WITHOUT HAVING TO CALL "Mockito.mock()" manually.
	 *
	 * In the following example - we'll create a mocked ArrayList with the manual way without using @Mock annotation:
	 */
	@Test
	public void whenNotUseMockAnnotationThenCorrect()
	{
		final List<String> mockList = Mockito.mock(ArrayList.class);

		mockList.add("one");
		Mockito.verify(mockList).add("one");
		assertEquals(0, mockList.size());

		Mockito.when(mockList.size()).thenReturn(100);
		assertEquals(100, mockList.size());
	}
}