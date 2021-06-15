package com.wln.enums.ci;

public enum ReportDate {

	ALL("All"), LAST_THIRTY_DAYS("Last 30 days"), LAST_SIXTY_DAYS("Last 60 days"), LAST_NINTY_DAYS("Last 90 days"),
	LAST_SIX_MONTHS("Last 6 months");

	private ReportDate(String name) {
		this.name = name;
	}

	private final String name;

	public String getName() {
		return name;
	}

	public static ReportDate getFrom(String date) {
		for (ReportDate reportDate : ReportDate.values()) {
			if (reportDate.getName().equals(date)) {
				return reportDate;
			}
		}
		return null;
	}

	public String toString() {
		return getName();
	}

}
