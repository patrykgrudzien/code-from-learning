package com.jurik99;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RxJavaUnitTest {

	private String result = "";

	// Simple subscription to a fix value
	@Test
	public void returnAValue() {
		final Observable<String> source = Observable.just("Hello"); // provides data
		// subscribe(Consumer<? super String> onNext)
		final Disposable subscriber = source.subscribe(stringWord -> {
			result = stringWord;
			System.out.println(result);
		});// Callable as subscriber
		subscriber.dispose();

		assertEquals("Hello", result);
		assertTrue(subscriber.isDisposed());
	}
}
