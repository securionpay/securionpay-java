package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class FastCredit {

    private boolean supported;
    private Long updated;


    public boolean isSupported() {
        return supported;
    }

    public Long getUpdated() {
        return updated;
    }

    @JsonIgnore
    private final Map<String, Object> other = new HashMap<>();

    public String get(String name) {
        return toStringNullSafe(other.get(name));
    }

    @JsonAnySetter
    private void set(String name, Object value) {
        other.put(name, value);
    }
}
