package com.wln.enums.common;

public enum SortOrder {

	RELEVANCE("Relevance"),
	DATE("Date"),
	MOST_CITED("Most Cited"),
	MOST_USED("Most Used"),
	COURT_LEVEL("Court Level"),
	TERM_FREQUENCY("Term Frequency");
	
	private SortOrder(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static SortOrder getFrom(String sOrder) {
		for(SortOrder sortOrder :  SortOrder.values()) {
			if(sortOrder.getName().equals(sOrder)) {
				return sortOrder;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}
}
