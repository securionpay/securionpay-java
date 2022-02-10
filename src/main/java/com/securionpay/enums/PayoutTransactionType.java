package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PayoutTransactionType {
	CHARGE("charge"),
	REFUND("refund"),
	CREDIT("credit"),
	CHARGEBACK("chargeback"),
	CHARGEBACK_REPRESENTED("chargeback_represented"),
	ADJUSTMENT("adjustment"),
	RESERVE_WITHHOLD("reserve_withhold"),
	RESERVE_RELEASE("reserve_release"),
	ACQUIRER_FEE("acquirer_fee"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	PayoutTransactionType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static PayoutTransactionType fromValue(String value) {
		for (PayoutTransactionType payoutStatus : values()) {
			if (payoutStatus.value.equalsIgnoreCase(value)) {
				return payoutStatus;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
