package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Interval {

	HOUR("hour"),
	DAY("day"),
	WEEK("week"),
	MONTH("month"),
	YEAR("year"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	Interval(String value) {
		this.value = value;
	}

	@JsonCreator
	public static Interval fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (Interval interval : values()) {
			if (interval.value.equalsIgnoreCase(value)) {
				return interval;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
