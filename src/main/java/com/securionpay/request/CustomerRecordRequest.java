package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustomerRecordRequest {
	private String email;
	private boolean subscription;

	public CustomerRecordRequest() {
	}

	public CustomerRecordRequest(String email, boolean subscription) {
		this.email = email;
		this.subscription = subscription;
	}

	public String getEmail() {
		return email;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public CustomerRecordRequest email(String email) {
		this.email = email;
		return this;
	}

	public CustomerRecordRequest subscription(boolean subscription) {
		this.subscription = subscription;
		return this;
	}
}
