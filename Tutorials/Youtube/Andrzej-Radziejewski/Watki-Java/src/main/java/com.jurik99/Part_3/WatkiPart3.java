package com.jurik99.Part_3;

import lombok.Getter;

class Pisz {

	// nie robimy "synchronized" tutaj ponieważ w innym miejscu wcale mozemy nie potrzebowac miec tej metody zsynchronizowanej
	void pisz(final String message) {
		System.out.println(Thread.currentThread().getName());
		System.out.print("** " + message);
		try {
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			System.out.println("Przerwano wątek!");
		}
		System.out.println(" **");
	}
}

@Getter
class Pisarz implements Runnable {

	private String message;
	private final Pisz piszObject;

	private Thread thread;

	Pisarz(final String message, final Pisz piszObject) {
		this.piszObject = piszObject;
		this.message = message;

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		// synchronizujemy dzialanie metody, w której usypiany jest watek (przy tym podejsciu, synchronizujemy juz tylko URUCHOMIONY watek !!!)
		synchronized (piszObject) {
			piszObject.pisz(message);
		}
	}
}

public class WatkiPart3 {

	public static void main(final String[] args) {

		final Pisz piszObject = new Pisz();
		final Pisarz p1 = new Pisarz("To jest", piszObject);
		final Pisarz p2 = new Pisarz("synchronizacja", piszObject);
		final Pisarz p3 = new Pisarz("wątków", piszObject);

		try {
			p1.getThread().join();
			p2.getThread().join();
			p3.getThread().join();
		} catch (final InterruptedException e) {
			System.out.println("Przerwano!");
		}
	}
}
