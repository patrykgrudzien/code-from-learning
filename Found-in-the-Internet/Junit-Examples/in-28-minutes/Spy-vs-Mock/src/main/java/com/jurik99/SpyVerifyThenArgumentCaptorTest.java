package com.jurik99;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;

public class SpyVerifyThenArgumentCaptorTest
{
	@Test
	public void test()
	{
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		assertEquals(0, arrayListMock.size());  // a mock always returns default values when a method is not stubbed
		/**
		 * We DON'T tell anything to mock to do something.
		 *
		 * Mocks return default value.
		 * If we stub it, it would return whatever we stubbed !!!
		 *
		 * A mock DOESN'T get any business logic from actual class it is mocking !!!
		 */
		stub(arrayListMock.size()).toReturn(5);

		// --- we are inserting into a MOCK ---
		arrayListMock.add("Dummy"); // we are NOT really adding value to REAL class of ArrayList<String>

		assertEquals(5, arrayListMock.size());  // even if we added 6th element to the list, size remains 5

		/**
		 * Let's say we now want to have similar object to MOCK (keep existing functionality of ArrayList class) but
		 * with possibiliy to OVERRIDE specific functionality and to check how many times called methods are invoked.
		 */

		// --- SPY GETS ALL LOGIC FROM THE CLASS ---
		ArrayList<String> arrayListSpy = spy(ArrayList.class);  // it's like creating REAL ArrayList<String>
		// we can stub specific methods of our choice
		assertEquals(0, arrayListSpy.size());

		arrayListSpy.add("FIRST");
		assertEquals(1, arrayListSpy.size());   // size has been changed

		// great thing about SPY is that we can OVERRIDE specific methods
		stub(arrayListSpy.size()).toReturn(10);
		assertEquals(10, arrayListSpy.size());
		// SPY is also called PARTIAL MOCK

		// we can also VERIFY invocation of specific methods
		arrayListSpy.add("SECOND");

		// a SPY enables us to watch real action, as well as change behavior when needed
		verify(arrayListSpy, never()).remove("FIRST");

		// very SIMILAR to "verify()" is "then()" !!!
		then(arrayListSpy).should(never()).clear();
		then(arrayListSpy).should(times(1)).add("FIRST");
		then(arrayListSpy).should(times(1)).add("SECOND");

		/**
		 * we want to also CAPTURE argument which is passed to "add()" method
		 * 1) declare Argument Captor
		 * 2) Define Argument Captor on specific method call
		 * 3) Capture the argument
		 */
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		then(arrayListSpy).should(times(2)).add(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(), is("SECOND"));
	}
}
