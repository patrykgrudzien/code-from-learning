package me.jurik99.Section_6;

@SuppressWarnings("DanglingJavadoc")
public class Intro
{
	/**
	 * 1. Scope refers to the lifecycle of a bean
	 *
	 * 2. How long does the bean live?
	 *
	 * 3. How many instances are created?
	 *
	 * 4. How is the bean shared?
	 *
	 * By default bean is created in SINGLETON scope.
	 * - What is a com.jurik99.Singleton?
	 *      - Spring Container creates only one instance of the bean, by default
	 *      - It is cached in memory
	 *      - All request for the bean will return a SHARED reference to the SAME bean
	 */
}
