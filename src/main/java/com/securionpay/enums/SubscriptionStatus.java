package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionStatus {

	TRIALING("trialing"),
	ACTIVE("active"),
	PAST_DUE("past_due"),
	CANCELED("canceled"),
	UNPAID("unpaid"),
	INCOMPLETE("incomplete"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	SubscriptionStatus(String value) {
		this.value = value;
	}

	@JsonCreator
	public static SubscriptionStatus fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (SubscriptionStatus subscriptionStatus : values()) {
			if (subscriptionStatus.value.equalsIgnoreCase(value)) {
				return subscriptionStatus;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
