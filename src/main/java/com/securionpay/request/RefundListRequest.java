package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.response.Charge;

import java.util.HashMap;
import java.util.Map;

public class RefundListRequest {

    private Integer limit;
    private String startingAfterId;
    private String endingBeforeId;
    private Boolean includeTotalCount;

    private CreatedFilter created;

    private String chargeId;

    @JsonIgnore
    private final Map<String, Object> other = new HashMap<>();

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

    public String getChargeId() {
        return chargeId;
    }

    public RefundListRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public RefundListRequest startingAfterId(String startingAfterId) {
        this.startingAfterId = startingAfterId;
        return this;
    }

    public RefundListRequest endingBeforeId(String endingBeforeId) {
        this.endingBeforeId = endingBeforeId;
        return this;
    }

    public RefundListRequest includeTotalCount(Boolean includeTotalCount) {
        this.includeTotalCount = includeTotalCount;
        return this;
    }

    public RefundListRequest includeTotalCount() {
        return this.includeTotalCount(Boolean.TRUE);
    }

    public RefundListRequest created(CreatedFilter created) {
        this.created = created;
        return this;
    }

    public RefundListRequest chargeId(String chargeId) {
        this.chargeId = chargeId;
        return this;
    }

    public RefundListRequest charge(Charge charge) {
        return chargeId(charge.getId());
    }
    
    @JsonAnyGetter
    private Map<String, Object> getOtherMap() {
        return this.other;
    }

    @JsonAnySetter
    public RefundListRequest set(String name, Object value) {
        this.other.put(name, value);
        return this;
    }
}
