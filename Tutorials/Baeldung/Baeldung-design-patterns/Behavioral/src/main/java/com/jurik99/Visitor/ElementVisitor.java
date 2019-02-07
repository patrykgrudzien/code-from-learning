package com.jurik99.Visitor;

public class ElementVisitor implements Visitor {

	@Override
	public void visit(final Element element) {
		System.out.println("Processing " + element.getType() + " element with UUID: " + element.getUuid());
	}
}
