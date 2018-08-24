package com.jurik99.Part_1;

@SuppressWarnings("Duplicates")
class NowyWatek implements Runnable {

	private String name;

	NowyWatek(final String name) {
		this.name = name;
		Thread thread = new Thread(this, name);
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
public class WatkiPart1 {

	public static void main(final String[] args) {

		new NowyWatek("JEDEN");
		new NowyWatek("DWA");
		new NowyWatek("TRZY");
		new NowyWatek("CZTERY");

		try {
			System.out.println("Usypiam wątek główny -> " + Thread.currentThread().getName());
			Thread.sleep(8000);
			System.out.println("Wznawiam wątek główny -> " + Thread.currentThread().getName());
		} catch (final InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("Zakończono wykonywanie wątku głównego -> " + Thread.currentThread().getName());
	}
}
