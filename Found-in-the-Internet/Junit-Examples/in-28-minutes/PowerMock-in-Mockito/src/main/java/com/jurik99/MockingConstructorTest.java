package com.jurik99;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {

	@InjectMocks
	private SystemUnderTest systemUnderTest;

	@Mock
	private ArrayList mockList;

	@Test
	public void test() throws Exception {
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		when(mockList.size()).thenReturn(5);

		int arrayListSize = systemUnderTest.methodUsingAnArrayListConstructor();
		assertEquals(5, arrayListSize);
	}
}
