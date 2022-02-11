package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.response.Charge;

import java.util.HashMap;
import java.util.Map;

public class FraudWarningListRequest {

    private Integer limit;
    private String startingAfterId;
    private String endingBeforeId;
    private Boolean includeTotalCount;

    private CreatedFilter created;

    private String chargeId;
    private Boolean actionable;

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

    public Boolean getActionable() {
        return actionable;
    }

    public FraudWarningListRequest limit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public FraudWarningListRequest startingAfterId(String startingAfterId) {
        this.startingAfterId = startingAfterId;
        return this;
    }

    public FraudWarningListRequest endingBeforeId(String endingBeforeId) {
        this.endingBeforeId = endingBeforeId;
        return this;
    }

    public FraudWarningListRequest includeTotalCount(Boolean includeTotalCount) {
        this.includeTotalCount = includeTotalCount;
        return this;
    }

    public FraudWarningListRequest includeTotalCount() {
        return this.includeTotalCount(Boolean.TRUE);
    }

    public FraudWarningListRequest created(CreatedFilter created) {
        this.created = created;
        return this;
    }

    public FraudWarningListRequest chargeId(String chargeId) {
        this.chargeId = chargeId;
        return this;
    }

    public FraudWarningListRequest charge(Charge charge) {
        return chargeId(charge.getId());
    }

    public FraudWarningListRequest actionable(Boolean actionable) {
        this.actionable = actionable;
        return this;
    }

    @JsonAnyGetter
    private Map<String, Object> getOtherMap() {
        return this.other;
    }

    @JsonAnySetter
    public FraudWarningListRequest set(String name, Object value) {
        this.other.put(name, value);
        return this;
    }
}
