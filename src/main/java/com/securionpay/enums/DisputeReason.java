package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DisputeReason {

	FRAUDULENT("fraudulent"),
	UNRECOGNIZED("unrecognized"),
	DUPLICATE("duplicate"),
	SUBSCRIPTION_CANCELED("subscription_canceled"),
	PRODUCT_NOT_RECEIVED("product_not_received"),
	PRODUCT_UNACCEPTABLE("product_unacceptable"),
	CREDIT_NOT_PROCESSED("credit_not_processed"),
	GENERAL("general"),
	
	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNKNOWN("unknown");

	private final String value;

	DisputeReason(String value) {
		this.value = value;
	}

	@JsonCreator
	public static DisputeReason fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (DisputeReason disputeReason : values()) {
			if (disputeReason.value.equalsIgnoreCase(value)) {
				return disputeReason;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
