package com.jurik99.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Document extends Element {

	private List<Element> elements = new ArrayList<>();

	public Document(final String uuid, final String type) {
		super(uuid, type);
	}

	@Override
	public void accept(final Visitor visitor) {
		elements.forEach(element -> element.accept(visitor));
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(final List<Element> elements) {
		this.elements = elements;
	}
}
