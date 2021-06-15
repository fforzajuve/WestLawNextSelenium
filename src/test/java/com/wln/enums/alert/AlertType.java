package com.wln.enums.alert;

public enum AlertType {

	ALL("All"),
	WESTCLIP("WestClip"),
	KEYCITE("KeyCite"),
	COURT_WIRE_ALERT("Court Wire Alert"),
	DOCKET_ALERT("Docket Alert"),
	DOCKET_TRACK("Docket Track"),
	COMPANY_INVESTIGATOR("Company Investigator"),
	PUBLICATION_ALERT("Publication Alert");
	
	private AlertType(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static AlertType getFrom(String type) {
		for(AlertType aType :  AlertType.values()) {
			if(aType.getName().equals(type)) {
				return aType;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}
}
