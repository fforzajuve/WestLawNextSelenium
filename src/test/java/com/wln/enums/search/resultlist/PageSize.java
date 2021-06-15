package com.wln.enums.search.resultlist;

public enum PageSize {

	TWENTY("20 per page"),
	FIFTY("50 per page"),
	HUNDRED("100 per page");

	private PageSize(String name) {
		this.name = name;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public static PageSize getFrom(String size) {
		for (PageSize pageSize : PageSize.values()) {
			if (pageSize.getName().equals(size)) {
				return pageSize;
			}
		}
		return null;
	}

	public String toString() {
		return getName();
	}

}
