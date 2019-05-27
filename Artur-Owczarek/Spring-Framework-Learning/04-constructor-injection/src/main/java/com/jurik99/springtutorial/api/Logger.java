package com.jurik99.springtutorial.api;

public interface Logger {
	
	void log(final String message);
	
	void setName(final String name);
	
	void setVersion(final int version);
	
}
