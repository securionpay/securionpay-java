package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Subscription;

@JsonInclude(Include.NON_NULL)
public class SubscriptionUpdateRequest {

	@JsonIgnore
	private String subscriptionId;
	@JsonIgnore
	private String customerId;

	private String planId;
	private CardRequest card;
	private Integer quantity;
	private Boolean captureCharges;
	private Long trialEnd;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public SubscriptionUpdateRequest() {
	}

	public SubscriptionUpdateRequest(String subscriptionId, String customerId) {
		subscriptionId(subscriptionId).customerId(customerId);
	}

	public SubscriptionUpdateRequest(Subscription subscription) {
		subscription(subscription);
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getPlanId() {
		return planId;
	}

	public CardRequest getCard() {
		return card;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Boolean getCaptureCharges() {
		return captureCharges;
	}

	public Long getTrialEnd() {
		return trialEnd;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public SubscriptionUpdateRequest subscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	public SubscriptionUpdateRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public SubscriptionUpdateRequest subscription(Subscription subscription) {
		return subscriptionId(subscription.getId()).customerId(subscription.getCustomerId());
	}

	public SubscriptionUpdateRequest planId(String planId) {
		this.planId = planId;
		return this;
	}

	public SubscriptionUpdateRequest card(CardRequest card) {
		this.card = card;
		return this;
	}

	public SubscriptionUpdateRequest quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public SubscriptionUpdateRequest captureCharges(Boolean captureCharges) {
		this.captureCharges = captureCharges;
		return this;
	}

	public SubscriptionUpdateRequest trialEnd(Long trialEnd) {
		this.trialEnd = trialEnd;
		return this;
	}

	public SubscriptionUpdateRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public SubscriptionUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
