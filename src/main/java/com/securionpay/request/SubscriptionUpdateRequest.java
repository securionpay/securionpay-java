package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Plan;
import com.securionpay.response.Subscription;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class SubscriptionUpdateRequest {

	@JsonIgnore
	private String subscriptionId;

	private String planId;
	private CardRequest card;
	private Integer quantity;
	private Boolean captureCharges;
	private Long trialEnd;
	private ShippingRequest shipping;
	private BillingRequest billing;
	private Map<String, String> metadata;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public SubscriptionUpdateRequest() {
	}

	public SubscriptionUpdateRequest(String subscriptionId) {
		subscriptionId(subscriptionId);
	}

	public SubscriptionUpdateRequest(Subscription subscription) {
		subscription(subscription);
	}

	public String getSubscriptionId() {
		return subscriptionId;
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

	public ShippingRequest getShipping() {
		return shipping;
	}

	public BillingRequest getBilling() {
		return billing;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public SubscriptionUpdateRequest subscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	public SubscriptionUpdateRequest subscription(Subscription subscription) {
		return subscriptionId(subscription.getId());
	}

	public SubscriptionUpdateRequest planId(String planId) {
		this.planId = planId;
		return this;
	}

	public SubscriptionUpdateRequest plan(Plan plan) {
		return planId(plan.getId());
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

	public SubscriptionUpdateRequest shipping(ShippingRequest shipping) {
		this.shipping = shipping;
		return this;
	}

	public SubscriptionUpdateRequest billing(BillingRequest billing) {
		this.billing = billing;
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
