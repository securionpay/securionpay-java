package com.securionpay.response;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.PayoutTransactionType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class PayoutTransaction {
    private String id;
    private Long created;
    private String type;
    private Long amount;
    private String currency;
    private String description;
    private Long fee;
    private String source;
    private String payout;
    private BigDecimal exchangeRate;

    @JsonIgnore
    private Map<String, Object> other = new HashMap<>();

    public String get(String name) {
        return toStringNullSafe(other.get(name));
    }

    @JsonAnySetter
    private void set(String name, Object value) {
        other.put(name, value);
    }

    public String getId() {
        return id;
    }

    public Long getCreated() {
        return created;
    }

    public PayoutTransactionType getType() {
        return PayoutTransactionType.fromValue(type);
    }

    public String getTypeAsString() {
        return type;
    }

    public Long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public Long getFee() {
        return fee;
    }

    public String getSource() {
        return source;
    }

    public String getPayout() {
        return payout;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
}