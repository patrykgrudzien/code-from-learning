package com.jurik99;

public class AsynchronousCallback {

	// Driver Program
	public static void main(final String[] args) {

		final B_Async obj = new B_Async();
		final OnGeekEventListenerAsync listener = new A_Async();
		obj.registerOnGeekEventListener(listener);
		obj.doGeekStuff();

		System.out.println("Printing something in the MAIN thread.");
	}
}

// Java program to illustrate Asynchronous callback
interface OnGeekEventListenerAsync {

	// this can be any type of method
	void onGeekEvent();
}

class B_Async {

	private OnGeekEventListenerAsync listener; // listener field

	// setting the listener
	public void registerOnGeekEventListener(final OnGeekEventListenerAsync listener) {
		this.listener = listener;
	}

	// My Asynchronous task
	public void doGeekStuff() {

		// An Async task always executes in new thread
		new Thread(new Runnable() {
			public void run() {

				Thread.currentThread().setName("NEW CUSTOM THREAD");

				// perform any operation
				System.out.println("Performing operation in Asynchronous Task");

				// check if listener is registered.
				if (listener != null) {

					// invoke the callback method of class A
					listener.onGeekEvent();
				}
			}
		}).start();
	}
}

class A_Async implements OnGeekEventListenerAsync {

	@Override
	public void onGeekEvent() {
		System.out.println("Performing callback after Asynchronous Task");
		// perform some routine operation
	}
	// some class A methods
}
