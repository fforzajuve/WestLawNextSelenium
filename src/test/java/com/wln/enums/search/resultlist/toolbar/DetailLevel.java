package com.wln.enums.search.resultlist.toolbar;

public enum DetailLevel {
	
	LESS_DETAIL("Less Detail"),
	MORE_DETAIL("More Detail"),
	MOST_DETAIL("Most Detail");

	private DetailLevel(String name) {
		this.name = name;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public static DetailLevel getFrom(String dLevel) {
		for (DetailLevel detailLevel : DetailLevel.values()) {
			if (detailLevel.getName().equals(dLevel)) {
				return detailLevel;
			}
		}
		return null;
	}

	public String toString() {
		return getName();
	}


}
