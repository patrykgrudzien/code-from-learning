package com.jurik99.messenger.exception;

public class DataNotFoundException extends RuntimeException
{
	// --- RuntimeException HAS "serialVersionUID" !!! ---
	private static final long serialVersionUID = 5960497640307870163L;

	public DataNotFoundException(final String message)
	{
		super(message);
	}
}
