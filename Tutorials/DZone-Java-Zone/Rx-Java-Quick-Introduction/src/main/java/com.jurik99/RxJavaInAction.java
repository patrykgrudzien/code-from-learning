package com.jurik99;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * What is Reactive Programming?
 *
 * Is is a style of programming where you define a source of data and a consumer of that data. Once you connect the consumer to
 * the source, the library (which is RxJava here) takes care of pushing the data, generated by the source, to the consumer.
 *
 * The above definition talks about three important things:
 * 1) Source of data
 * 2) Consumer of data
 * 3) Connecting Consumer to Source
 */
public class RxJavaInAction {

	public static void main(final String[] args) {

		// defining the source
		final Observable<Integer> source = Observable.range(1, 5);

		// defining the consumer
		Observer<Integer> consumer = new Observer<Integer>() {

			@Override
			public void onSubscribe(final Disposable disposable) {
				System.out.println("onSubscribe()");
			}

			@Override
			public void onNext(final Integer integer) {
				System.out.println("onNext() -> Integer: " + integer);
			}

			@Override
			public void onError(final Throwable throwable) {
				System.out.println("onError()");
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete()");
			}
		};

		// connecting the consumer to source
		source.subscribe(consumer);

	}
}
