package com.jurik99.Visitor;

import java.util.UUID;

/**
 * The purpose of a Visitor pattern is to define a new operation without introducing the modifications to an existing object structure.
 *
 * Imagine that we have a composite object which consists of components. The object’s structure is fixed – we either can’t change it, or we don’t plan to add new types
 * of elements to the structure.
 *
 * Now, how could we add new functionality to our code without modification of existing classes?
 *
 * The Visitor design pattern might be an answer. Simply put, we’ll have to do is to add a function which accepts the visitor class to each element of the structure.
 *
 * That way our components will allow the visitor implementation to “visit” them and perform any required action on that element.
 *
 * In other words, we’ll extract the algorithm which will be applied to the object structure from the classes.
 *
 * Consequently, we’ll make good use of the Open/Closed principle as we won’t modify the code, but we’ll still be able to extend the functionality by providing a new
 * Visitor implementation.
 */
public class Main {

	public static void main(final String[] args) {

		final Visitor visitor = new ElementVisitor();

		final Document document = new Document(generateUuid(), "Document");
		document.getElements().add(new JsonElement(generateUuid(), "JSON"));
		document.getElements().add(new JsonElement(generateUuid(), "JSON"));
		document.getElements().add(new XmlElement(generateUuid(), "XML"));

		document.accept(visitor);

		/**
		 * The Visitor pattern is great to separate the algorithm from the classes on which it operates. Besides that, it makes adding new operation more easily, just
		 * by providing a new implementation of the Visitor.
		 *
		 * Furthermore, we don’t depend on components interfaces, and if they are different, that’s fine, since we have a separate algorithm for processing per concrete
		 * element.
		 *
		 * Moreover, the Visitor can eventually aggregate data based on the element it traverses.
		 */
	}

	private static String generateUuid() {
		return UUID.randomUUID().toString();
	}
}
