package com.jurik99.springtutorial.implementation;

import java.util.Date;
import com.jurik99.springtutorial.api.Logger;

public class LoggerImpl implements Logger {

	private String name;
	private int version;
	
	public void log(String message) {
		System.out.println(new Date() + " [" + name + "]" + ", version = (" + version + ") - " + message);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
