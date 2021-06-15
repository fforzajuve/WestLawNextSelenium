package com.wln.enums.common;

public enum TimeZone {

	GMT_12_00("(GMT-12:00) International Date Line West"),
	GMT_09_00("(GMT-09:00) Alaska"),
	GMT__03_00("(GMT+03:00) Minsk");

	
	private TimeZone(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static TimeZone getFrom(String tZone) {
		for(TimeZone timeZone :  TimeZone.values()) {
			if(timeZone.getName().equals(tZone)) {
				return timeZone;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}
}
