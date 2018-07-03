package com.jurik99;

public class MySimpleClass
{
	public MySimpleClass()
	{
		simpleMethod();
	}

	/*
	 * Wewnątrz cudzysłowu mogę podać wybrane przez siebie wartości.
     * Aby je odczytać, odwołuje się do nich przez refleksję.
     *
     * Poniżej kod, który w tym przypadku wypisuje na ekranie konsoli wartości adnotacji:
	 */
	@MyAnnotation(firstAttribute = "Patryk", secondAttribute = "Grudzien")
	public void simpleMethod()
	{
		MyAnnotation firstAnnotation = null;
		MyAnnotation secondAnnotation = null;

		try
		{
			/*
			 * Pobieram bieżącą klasę, a następnie metodę, której tyczy się adnotacja.
             * Z metody wyciągam adnotację.
			 */
			firstAnnotation = this.getClass().getMethod("simpleMethod").getAnnotation(MyAnnotation.class);
			// --- To use getMethod() we have to make it PUBLIC !!! ---
			secondAnnotation = this.getClass().getMethod("simpleMethod").getAnnotation(MyAnnotation.class);
		}
		catch (final NoSuchMethodException exception)
		{
			exception.printStackTrace();
		}

		if (firstAnnotation != null)
		{
			System.out.println("First attribute: " + firstAnnotation.firstAttribute());
		}
		if (secondAnnotation != null)
		{
			System.out.println("Second attribute: " + secondAnnotation.secondAttribute());
		}
	}
}
