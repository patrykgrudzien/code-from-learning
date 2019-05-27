package com.jurik99.springtutorial.implementation;

import java.util.Date;
import com.jurik99.springtutorial.api.Logger;

public class LoggerImpl implements Logger {

	public void log(String message) {
		System.out.println(new Date() + ": " + message);
	}

}
