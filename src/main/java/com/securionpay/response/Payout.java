package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Payout {
    private String id;
    private Long created;
    private Integer amount;
    private String currency;
    private Long periodStart;
    private Long periodEnd;

    @JsonIgnore
    private Map<String, Object> other = new HashMap<>();

    public String getId() {
        return id;
    }

    public Long getCreated() {
        return created;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getPeriodStart() {
        return periodStart;
    }

    public Long getPeriodEnd() {
        return periodEnd;
    }

    public String get(String name) {
        return toStringNullSafe(other.get(name));
    }

    @JsonAnySetter
    private void set(String name, Object value) {
        other.put(name, value);
    }
}
