package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.CustomerRecord;

@JsonInclude(Include.NON_NULL)
public class CustomerRecordRefreshRequest {
	@JsonIgnore
	private String customerRecordId;
	private Boolean subscription;

	public CustomerRecordRefreshRequest() {
	}

	public CustomerRecordRefreshRequest(String customerRecordId) {
		this.customerRecordId = customerRecordId;
	}

	public CustomerRecordRefreshRequest(CustomerRecord customerRecord) {
		this.customerRecordId = customerRecord.getId();
	}

	public String getCustomerRecordId() {
		return customerRecordId;
	}

	public Boolean isSubscription() {
		return subscription;
	}

	public CustomerRecordRefreshRequest customerRecordId(String customerRecordId) {
		this.customerRecordId = customerRecordId;
		return this;
	}

	public CustomerRecordRefreshRequest customerRecord(CustomerRecord customerRecord) {
		this.customerRecordId = customerRecord.getId();
		return this;
	}

	public CustomerRecordRefreshRequest subscription(boolean subscription) {
		this.subscription = subscription;
		return this;
	}
}
