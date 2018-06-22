package com.jurik99.Adapter;

public class SocketObjectAdapterImpl implements SocketAdapter
{
	// --- Using composition for adapter pattern ---
	private Socket socket = new Socket();

	@Override
	public Volt get120Volt()
	{
		return socket.getVolt();
	}

	@Override
	public Volt get12Volt()
	{
		final Volt volt = socket.getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get3Volt()
	{
		final Volt volt = socket.getVolt();
		return convertVolt(volt, 40);
	}

	private Volt convertVolt(final Volt volt, final int i)
	{
		return new Volt(volt.getVolts() / i);
	}
}
