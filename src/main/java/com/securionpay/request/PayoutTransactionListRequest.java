package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayoutTransactionListRequest {
    private Integer limit;
    private String payout;
    private String source;
    private String startingAfterId;
    private String endingBeforeId;
    private CreatedFilter created;

    @JsonIgnore
    private Map<String, Object> other = new HashMap<>();

    public CreatedFilter getCreated() {
        return created;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getPayout() {
        return payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStartingAfterId() {
        return startingAfterId;
    }

    public void setStartingAfterId(String startingAfterId) {
        this.startingAfterId = startingAfterId;
    }

    public String getEndingBeforeId() {
        return endingBeforeId;
    }

    public void setEndingBeforeId(String endingBeforeId) {
        this.endingBeforeId = endingBeforeId;
    }

    public void setCreated(CreatedFilter created) {
        this.created = created;
    }

    @JsonAnyGetter
    private Map<String, Object> getOtherMap() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }
}