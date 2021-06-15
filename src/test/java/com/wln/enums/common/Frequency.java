package com.wln.enums.common;

public enum Frequency {
	
	DAILY("Daily"),
	WEEKDAYS("Weekdays (M-F)"),
	WEEKLY("Weekly"),
	BI_WEEKLY("Bi-Weekly"),
	MONTHLY("Monthly");
	
	private Frequency(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static Frequency getFrom(String freq) {
		for(Frequency frequency :  Frequency.values()) {
			if(frequency.getName().equals(freq)) {
				return frequency;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
