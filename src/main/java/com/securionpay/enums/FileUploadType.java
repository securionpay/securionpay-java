package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FileUploadType {
	PDF("pdf"),
	JPG("jpg"),
	PNG("png"),
	CSV("csv"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	FileUploadType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static FileUploadType fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (FileUploadType purpose : values()) {
			if (purpose.value.equalsIgnoreCase(value)) {
				return purpose;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
