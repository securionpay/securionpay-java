package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {

	INVALID_NUMBER("invalid_number"),
	INVALID_EXPIRY_MONTH("invalid_expiry_month"),
	INVALID_EXPIRY_YEAR("invalid_expiry_year"),
	INVALID_CVC("invalid_cvc"),
	INCORRECT_CVC("incorrect_cvc"),
	INCORRECT_ZIP("incorrect_zip"),
	EXPIRED_CARD("expired_card"),
	INSUFFICIENT_FUNDS("insufficient_funds"),
	LOST_OR_STOLEN("lost_or_stolen"),
	SUSPECTED_FRAUD("suspected_fraud"),
	CARD_DECLINED("card_declined"),
	PROCESSING_ERROR("processing_error"),
	BLACKLISTED("blacklisted"),
	BLOCKED("blocked"),
	EXPIRED_TOKEN("expired_token"),
	LIMIT_EXCEEDED("limit_exceeded"),
	AUTHENTICATION_REQUIRED("authentication_required"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	ErrorCode(String value) {
		this.value = value;
	}

	@JsonCreator
	public static ErrorCode fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (ErrorCode errorCode : values()) {
			if (errorCode.value.equalsIgnoreCase(value)) {
				return errorCode;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
