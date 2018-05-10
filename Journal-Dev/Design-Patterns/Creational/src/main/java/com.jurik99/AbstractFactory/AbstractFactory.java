package com.jurik99.AbstractFactory;

public interface AbstractFactory {

	/**
	 * By creating Factory of factories WE GET RID OF (if-else) block which provides us to return proper sub-class
	 */
	Computer createComputer();
}
