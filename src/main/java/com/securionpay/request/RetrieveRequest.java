package com.securionpay.request;

public class RetrieveRequest {

    private Expand expand;

    public RetrieveRequest expand(Expand expand) {
        this.expand = expand;
        return this;
    }

    public Expand getExpand() {
        return expand;
    }
}
