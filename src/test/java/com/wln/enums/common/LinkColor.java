package com.wln.enums.common;

public enum LinkColor {

	BLUE("Blue"), BLACK("Black");

	private LinkColor(String name) {
		this.name = name;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public static LinkColor getFrom(String color) {
		for (LinkColor linkColor : LinkColor.values()) {
			if (linkColor.getName().equals(color)) {
				return linkColor;
			}
		}
		return null;
	}

	public String toString() {
		return getName();
	}

}
