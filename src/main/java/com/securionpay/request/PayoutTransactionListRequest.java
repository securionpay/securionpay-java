package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayoutTransactionListRequest {
    private Integer limit;
    private String payout;
    private String source;
    private String startingAfterId;
    private String endingBeforeId;

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
}