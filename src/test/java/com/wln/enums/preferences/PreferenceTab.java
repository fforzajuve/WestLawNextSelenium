package com.wln.enums.preferences;

public enum PreferenceTab {
	
	PROFILE("Profile"),
	BILLING("Billing"),
	SEARCH("Search"),
	HISTORY("History"),
	FEATURES("Features"),
	DELIVERY("Delivery"),
	CITATIONS("Citations");
	
	private PreferenceTab(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static PreferenceTab getFrom(String tab) {
		for(PreferenceTab prefTab :  PreferenceTab.values()) {
			if(prefTab.getName().equals(tab)) {
				return prefTab;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
