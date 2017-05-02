package com.jurik99.Adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter
{
	@Override
	public Volt get120Volt()
	{
		// --- return new Volt(120); from Socket class ---
		return getVolt();
	}

	@Override
	public Volt get12Volt()
	{
		final Volt volt = getVolt();
		return convertVolt(volt, 10);
	}

	@Override
	public Volt get3Volt()
	{
		final Volt volt = getVolt();
		return convertVolt(volt, 40);
	}

	private Volt convertVolt(final Volt volt, final int i)
	{
		return new Volt(volt.getVolts() / i);
	}
}
