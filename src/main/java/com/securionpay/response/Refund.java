package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.RefundReason;
import com.securionpay.enums.RefundStatus;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Refund {

    private String id;
    private Long created;
    private Integer amount;
    private String currency;
    private String charge;
    private String reason;
    private String status;

    @JsonIgnore
    private final Map<String, Object> other = new HashMap<>();

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

    public String getCharge() {
        return charge;
    }

    public RefundReason getReason() {
        return RefundReason.fromValue(reason);
    }

    public String getReasonAsString() {
        return reason;
    }

    public RefundStatus getStatus() {
        return RefundStatus.fromValue(status);
    }

    public String getStatusAsString() {
        return status;
    }

    public String get(String name) {
        return toStringNullSafe(other.get(name));
    }

    @JsonAnySetter
    private void set(String name, Object value) {
        other.put(name, value);
    }
}
