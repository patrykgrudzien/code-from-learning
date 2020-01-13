package com.jurik99;

public class SynchronousCallback {

	public static void main(final String[] args) {

		final B_Async obj = new B_Async();
		final OnGeekEventListenerAsync listener = new A_Async();
		obj.registerOnGeekEventListener(listener);
		obj.doGeekStuff();
	}
}

/**
 * Java program to illustrate synchronous callback
 */
interface OnGeekEventListener {

	// this can be any type of method
	void onGeekEvent();
}

/**
 * Class "B"
 */
class B {

	private OnGeekEventListenerAsync listener;

	public void registerOnGeekEventListener(final OnGeekEventListenerAsync listener) {
		this.listener = listener;
	}

	// my synchronous task
	public void doGeekStuff() {

		// perform any operation
		System.out.println("Performing callback before synchronous Task");

		// check if listener is registered.
		if (this.listener != null) {

			// invoke the callback method of class A
			listener.onGeekEvent();
		}
	}
}

/**
 * Class "A"
 */
class A implements OnGeekEventListenerAsync {

	@Override
	public void onGeekEvent() {
		System.out.println("Performing callback after synchronous Task");
		// perform some routine operation
	}
	// some class A methods
}
