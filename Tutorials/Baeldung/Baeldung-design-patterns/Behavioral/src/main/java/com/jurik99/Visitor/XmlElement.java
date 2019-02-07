package com.jurik99.Visitor;

public class XmlElement extends Element {

	public XmlElement(final String uuid, final String type) {
		super(uuid, type);
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
}
