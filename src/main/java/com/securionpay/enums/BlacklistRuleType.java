package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BlacklistRuleType {

	FINGERPRINT("fingerprint"),
	IP_ADDRESS("ip_address"),
	IP_COUNTRY("ip_country"),
	METADATA("metadata"),
	EMAIL("email"),
	USER_AGENT("user_agent"),
	ACCEPT_LANGUAGE("accept_language"),
	CARD_COUNTRY("card_country"),
	CARD_BIN("card_bin"),
	CARD_ISSUER("card_issuer"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	BlacklistRuleType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static BlacklistRuleType fromValue(String value) {
		for (BlacklistRuleType blacklistRuleType : values()) {
			if (blacklistRuleType.value.equalsIgnoreCase(value)) {
				return blacklistRuleType;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
