package com.jurik99;

import io.reactivex.Observable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RxJavaUnitTest {

	private String result = "";

	// Simple subscription to a fix value
	@Test
	public void returnAValue() {
		final Observable<String> source = Observable.just("Hello"); // provides data
		// subscribe(Consumer<? super String> onNext)
		source.subscribe(stringWord -> {
			result = stringWord;
			System.out.println(result);
		}); // Callable as subscriber

		assertEquals("Hello", result);
	}
}
