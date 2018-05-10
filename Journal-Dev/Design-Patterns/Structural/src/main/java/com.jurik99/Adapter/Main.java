package com.jurik99.Adapter;

public class Main {

	public static void main(final String[] args) {
		testClassAdapter();

		System.out.println("--------------------------------------------");

		testObjectAdapter();
	}

	private static void testClassAdapter() {
		final SocketAdapter socketAdapter = new SocketClassAdapterImpl();
		final Volt v3 = getVolt(socketAdapter, 3);
		final Volt v12 = getVolt(socketAdapter, 12);
		final Volt v120 = getVolt(socketAdapter, 120);
		System.out.println("v3 volts using Object Adapter = " + v3.getVolts());
		System.out.println("v12 volts using Object Adapter = " + v12.getVolts());
		System.out.println("v120 volts using Object Adapter = " + v120.getVolts());
	}

	private static void testObjectAdapter() {
		final SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		final Volt v3 = getVolt(sockAdapter, 3);
		final Volt v12 = getVolt(sockAdapter, 12);
		final Volt v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Object Adapter = " + v3.getVolts());
		System.out.println("v12 volts using Object Adapter = " + v12.getVolts());
		System.out.println("v120 volts using Object Adapter = " + v120.getVolts());
	}

	private static Volt getVolt(final SocketAdapter socketAdapter, final int i) {
		switch (i) {
			case 3:
				return socketAdapter.get3Volt();
			case 12:
				return socketAdapter.get12Volt();
			case 120:
				return socketAdapter.get120Volt();
			default:
				return socketAdapter.get120Volt();
		}
	}

	/*
	 * Some of the adapter design pattern example I could easily find in JDK classes are:
	 * Arrays.asList();
	 * InputStreamReader(InputStream) (returns a Reader)
	 * OutputStreamWriter(OutputStream) (returns a Writer)
	 */
}
