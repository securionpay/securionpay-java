package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CrossSaleOfferTemplate {

	IMAGE_AND_TEXT("image_and_text"),
	TEXT_ONLY("text_only"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	private CrossSaleOfferTemplate(String value) {
		this.value = value;
	}

	@JsonCreator
	public static CrossSaleOfferTemplate fromValue(String value) {
		for (CrossSaleOfferTemplate template : values()) {
			if (template.value.equalsIgnoreCase(value)) {
				return template;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}