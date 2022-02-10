package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FraudStatus {

	IN_PROGRESS("in_progress"),
	SAFE("safe"),
	SUSPICIOUS("suspicious"),
	FRAUDULENT("fraudulent"),
	UNKNOWN("unknown"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	FraudStatus(String value) {
		this.value = value;
	}

	@JsonCreator
	public static FraudStatus fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (FraudStatus fraudStatus : values()) {
			if (fraudStatus.value.equalsIgnoreCase(value)) {
				return fraudStatus;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
