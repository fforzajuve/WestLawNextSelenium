package com.wln.enums.alert;

public enum DeliverySectionTab {

	RECIPIENTS("Recipients"),
	LAYOUT_LIMITS("Layout and Limits");
	
	private DeliverySectionTab(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static DeliverySectionTab getFrom(String tab) {
		for(DeliverySectionTab deliveryTab :  DeliverySectionTab.values()) {
			if(deliveryTab.getName().equals(tab)) {
				return deliveryTab;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}
}
