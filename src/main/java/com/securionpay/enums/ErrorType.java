package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {

	INVALID_REQUEST("invalid_request"),
	CARD_ERROR("card_error"),
	GATEWAY_ERROR("gateway_error"),
	RATE_LIMIT_ERROR("rate_limit_error"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	ErrorType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static ErrorType fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (ErrorType errorType : values()) {
			if (errorType.value.equalsIgnoreCase(value)) {
				return errorType;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
