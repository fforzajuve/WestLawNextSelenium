package com.wln.enums.common;

public enum FontSize {
	
	NORMAL("Normal"), LARGE("Large");

	private FontSize(String name) {
		this.name = name;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public static FontSize getFrom(String size) {
		for (FontSize fontSize : FontSize.values()) {
			if (fontSize.getName().equals(size)) {
				return fontSize;
			}
		}
		return null;
	}

	public String toString() {
		return getName();
	}

}
