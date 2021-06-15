package com.wln.enums.common;

public enum DeliveryFormat {
	
	MICROSOFT_WORD("Microsoft Word"),
	WORD_PROCESSOR("Word Processor (RTF)"),
	PDF("PDF"),
	INLINE_HTML("Inline HTML");
	
	private DeliveryFormat(String name){
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	
	public static DeliveryFormat getFrom(String format) {
		for(DeliveryFormat deliveryFormat :  DeliveryFormat.values()) {
			if(deliveryFormat.getName().equals(format)) {
				return deliveryFormat;
			}
		}
		return null;
	}

	
	public String toString() {
		return getName();
	}

}
