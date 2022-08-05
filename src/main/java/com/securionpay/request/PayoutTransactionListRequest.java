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
    private String startingAfterId;
    private String endingBeforeId;
    private Boolean includeTotalCount;
    private CreatedFilter created;

    private String payout;
    private String source;

    @JsonIgnore
    private Map<String, Object> other = new HashMap<>();

    public Integer getLimit() {
        return limit;
    }

    public String getStartingAfterId() {
        return startingAfterId;
    }

    public String getEndingBeforeId() {
        return endingBeforeId;
    }

    public Boolean getIncludeTotalCount() {
        return includeTotalCount;
    }

    public CreatedFilter getCreated() {
        return created;
    }

    public String getPayout() {
        return payout;
    }

    public String getSource() {
        return source;
    }

    public PayoutTransactionListRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public PayoutTransactionListRequest startingAfterId(String startingAfterId) {
        this.startingAfterId = startingAfterId;
        return this;
    }

    public PayoutTransactionListRequest endingBeforeId(String endingBeforeId) {
        this.endingBeforeId = endingBeforeId;
        return this;
    }

    public PayoutTransactionListRequest includeTotalCount(Boolean includeTotalCount) {
        this.includeTotalCount = includeTotalCount;
        return this;
    }

    public PayoutTransactionListRequest created(CreatedFilter created) {
        this.created = created;
        return this;
    }

    public PayoutTransactionListRequest payout(String payout) {
        this.payout = payout;
        return this;
    }

    public PayoutTransactionListRequest source(String source) {
        this.source = source;
        return this;
    }

    @JsonAnyGetter
    private Map<String, Object> getOtherMap() {
        return other;
    }

    @JsonAnySetter
    public PayoutTransactionListRequest set(String name, Object value) {
        other.put(name, value);
        return this;
    }
}