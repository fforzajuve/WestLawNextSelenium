package com.wln.enums.common;

public enum Time {
	
	AM_12_00("12:00 AM"),
	AM_1_00("1:00 AM"),
	AM_2_00("2:00 AM"),
	AM_3_00("3:00 AM"),
	AM_4_00("4:00 AM"),
	AM_5_00("5:00 AM"),
	AM_6_00("6:00 AM"),
	AM_7_00("7:00 AM"),
	AM_8_00("8:00 AM"),
	AM_9_00("9:00 AM"),
	AM_10_00("10:00 AM"),
	AM_11_00("11:00 AM"),
	PM_12_00("12:00 PM"),
	PM_1_00("1:00 PM"),
	PM_2_00("2:00 PM"),
	PM_3_00("3:00 PM"),
	PM_4_00("4:00 PM"),
	PM_5_00("5:00 PM"),
	PM_6_00("6:00 PM"),
	PM_7_00("7:00 PM"),
	PM_8_00("8:00 PM"),
	PM_9_00("9:00 PM"),
	PM_10_00("10:00 PM"),
	PM_11_00("11:00 PM");
	
	
	private Time(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static Time getFrom(String time) {
		for(Time timeValue :  Time.values()) {
			if(timeValue.getName().equals(time)) {
				return timeValue;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
