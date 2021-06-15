package com.wln.enums.common;

public enum BrowseTab {
	ALL_CONTENT("All Content"),
	FEDERAL_MATERIALS("Federal Materials"),
	STATE_MATERIALS("State Materials"),
	PRACTICE_AREAS("Practice Areas"),
	TOOLS("Tools");
	
	private BrowseTab(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static BrowseTab getFrom(String tab) {
		for(BrowseTab browseTab :  BrowseTab.values()) {
			if(browseTab.getName().equals(tab)) {
				return browseTab;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
