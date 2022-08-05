package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DisputeStatus {

	RETRIEVAL_REQUEST_NEW("retrieval_request_new"),
	RETRIEVAL_REQUEST_RESPONSE_UNDER_REVIEW("retrieval_request_response_under_review"),
	RETRIEVAL_REQUEST_REPRESENTED("retrieval_request_represented"),

	CHARGEBACK_NEW("chargeback_new"),
	CHARGEBACK_RESPONSE_UNDER_REVIEW("chargeback_response_under_review"),
	CHARGEBACK_REPRESENTED_SUCCESSFULLY("chargeback_represented_successfully"),
	CHARGEBACK_REPRESENTED_UNSUCCESSFULLY("chargeback_represented_unsuccessfully"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	DisputeStatus(String value) {
		this.value = value;
	}

	@JsonCreator
	public static DisputeStatus fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (DisputeStatus disputeStatus : values()) {
			if (disputeStatus.value.equalsIgnoreCase(value)) {
				return disputeStatus;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
