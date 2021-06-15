package com.wln.enums.search;

public enum ContentType {
	
	OVERVIEW("Overview"),
	CASES("Cases"),
	KEY_NUMBERS("Key Numbers"),
	FORMS("Forms"),
	BRIEFS("Briefs"),
	JURY_VERDICTS_SETTLEMENTS("Jury Verdicts & Settlements"),
	ALL_RESULTS("All results");
	
	private ContentType(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static ContentType getFrom(String content) {
		for(ContentType contentType :  ContentType.values()) {
			if(contentType.getName().equals(content)) {
				return contentType;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
