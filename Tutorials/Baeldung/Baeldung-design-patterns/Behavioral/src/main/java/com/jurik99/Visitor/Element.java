package com.jurik99.Visitor;

public abstract class Element {

	private String uuid;
	private String type;

	public Element(final String uuid, final String type) {
		this.uuid = uuid;
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public String getType() {
		return type;
	}

	public abstract void accept(final Visitor visitor);
}
