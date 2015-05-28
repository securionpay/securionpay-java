package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Subscription;

@JsonInclude(Include.NON_EMPTY)
public class SubscriptionCancelRequest {

	@JsonIgnore
	private String subscriptionId;
	@JsonIgnore
	private String customerId;

	private Boolean atPeriodEnd;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public SubscriptionCancelRequest() {
	}

	public SubscriptionCancelRequest(String subscriptionId, String customerId) {
		subscriptionId(subscriptionId).customerId(customerId);
	}

	public SubscriptionCancelRequest(Subscription subscription) {
		subscription(subscription);
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Boolean getAtPeriodEnd() {
		return atPeriodEnd;
	}

	public SubscriptionCancelRequest subscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	public SubscriptionCancelRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public SubscriptionCancelRequest subscription(Subscription subscription) {
		return subscriptionId(subscription.getId()).customerId(subscription.getCustomerId());
	}

	public SubscriptionCancelRequest atPeriodEnd(Boolean atPeriodEnd) {
		this.atPeriodEnd = atPeriodEnd;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public SubscriptionCancelRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
