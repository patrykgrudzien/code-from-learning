package com.jurik99.injectMocksAnnotation;

import static org.junit.Assert.assertEquals;

import injectMocksAnnotation.MyDictionary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksExample
{
	/*
	 * Now - let's discuss how to use @InjectMocks annotation - to inject mock fields into the tested object
	 * automatically.
	 * In the following example - we use @InjectMocks to inject the mock "wordMap" into the "MyDictionary" object.
	 */
	@Mock
	private Map<String, String> wordMap;

	@InjectMocks
	private MyDictionary dictionary = new MyDictionary();

	@Test
	public void whenUseInjectMocksAnnotationThenCorrect()
	{
		Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
		assertEquals("aMeaning", dictionary.getMeaning("aWord"));
	}
}
