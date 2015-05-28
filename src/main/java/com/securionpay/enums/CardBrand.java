package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CardBrand {

	VISA("Visa"),
	AMERICAN_EXPRESS("American Express"),
	MASTERCARD("MasterCard"),
	MASTER("MasterCard"),
	DISCOVER("Discover"),
	JCB("JCB"),
	DINERS_CLUB("Diners Club"),
	UNKNOWN("Unknown"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	private CardBrand(String value) {
		this.value = value;
	}

	@JsonCreator
	public static CardBrand fromValue(String value) {
		for (CardBrand cardBrand : values()) {
			if (cardBrand.value.equalsIgnoreCase(value)) {
				return cardBrand;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
