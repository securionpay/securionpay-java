package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RefundStatus {
    FAILED("failed"),
    SUCCESSFUL("successful"),

    /**
     * Used when received value can't be mapped to this enumeration.
     */
    UNRECOGNIZED("unrecognized");

    private final String value;

    RefundStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static RefundStatus fromValue(String value) {
        if (value == null) {
            return null;
        }
        for (RefundStatus refundStatus : values()) {
            if (refundStatus.value.equalsIgnoreCase(value)) {
                return refundStatus;
            }
        }

        return UNRECOGNIZED;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
