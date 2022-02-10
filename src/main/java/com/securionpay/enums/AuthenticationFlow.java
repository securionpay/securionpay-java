package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AuthenticationFlow {
    CHALLENGE("challenge"), FRICTIONLESS("frictionless"),

    /**
     * Used when received value can't be mapped to this enumeration.
     */
    UNRECOGNIZED("unrecognized");

    private final String value;

    AuthenticationFlow(String value) {
        this.value = value;
    }

    @JsonCreator
    public static AuthenticationFlow fromValue(String value) {
        if (value == null) {
            return null;
        }
        for (AuthenticationFlow authenticationFlow : values()) {
            if (authenticationFlow.value.equalsIgnoreCase(value)) {
                return authenticationFlow;
            }
        }

        return UNRECOGNIZED;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

