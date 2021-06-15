package com.wln.enums.common;

public enum Weekday {
	
	SUNDAY("Sunday"),
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday");
	
	
	private Weekday(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static Weekday getFrom(String day) {
		for(Weekday dof :  Weekday.values()) {
			if(dof.getName().equals(day)) {
				return dof;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
