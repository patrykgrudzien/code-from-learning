package com.jurik99.Part_2;

import lombok.Getter;

@SuppressWarnings("Duplicates")
@Getter
class NowyWatek implements Runnable {

	private String name;
	private Thread thread;

	NowyWatek(final String name) {
		this.name = name;
		thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("Uruchomiono wątek potomny -> " + name);
		try {
			System.out.println("Wątek potomny -> " + name + " uśpiony.");
			Thread.sleep(2000);
			System.out.println("Wątek potomny -> " + name + " wznowiony.");
		} catch (final InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("Zakończono działanie wątku potomnego -> " + name);
	}
}

@SuppressWarnings("Duplicates")
public class WatkiPart2 {

	public static void main(final String[] args) {

		final NowyWatek nw1 = new NowyWatek("JEDEN");
		final NowyWatek nw2 = new NowyWatek("DWA");
		final NowyWatek nw3 = new NowyWatek("TRZY");
		final NowyWatek nw4 = new NowyWatek("CZTERY");

		try {
			nw1.getThread().join();
			nw2.getThread().join();
			nw3.getThread().join();
			nw4.getThread().join();
		} catch (final InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("Zakończono wykonywanie wątku głównego -> " + Thread.currentThread().getName());
	}
}