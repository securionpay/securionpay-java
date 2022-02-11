package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Subscription;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class SubscriptionCancelRequest {

	@JsonIgnore
	private String subscriptionId;

	private Boolean atPeriodEnd;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public SubscriptionCancelRequest() {
	}

	public SubscriptionCancelRequest(String subscriptionId) {
		subscriptionId(subscriptionId);
	}

	public SubscriptionCancelRequest(Subscription subscription) {
		subscription(subscription);
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public Boolean getAtPeriodEnd() {
		return atPeriodEnd;
	}

	public SubscriptionCancelRequest subscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	public SubscriptionCancelRequest subscription(Subscription subscription) {
		return subscriptionId(subscription.getId());
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
