package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LiabilityShift {
	NOT_POSSIBLE("not_possible"),
	FAILED("failed"),
	SUCCESSFUL("successful"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	LiabilityShift(String value) {
		this.value = value;
	}

	@JsonCreator
	public static LiabilityShift fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (LiabilityShift liabilityShift : values()) {
			if (liabilityShift.value.equalsIgnoreCase(value)) {
				return liabilityShift;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
