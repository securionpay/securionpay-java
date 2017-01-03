package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;
import com.securionpay.response.Plan;

@JsonInclude(Include.NON_NULL)
public class SubscriptionRequest {

	@JsonIgnore
	private String customerId;

	private String planId;
	private CardRequest card;
	private Integer quantity;
	private Boolean captureCharges;
	private Long trialEnd;
	private ShippingRequest shipping;
	private BillingRequest billing;
	private Map<String, String> metadata = new HashMap<>();

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public SubscriptionRequest() {
	}

	public SubscriptionRequest(String customerId, String planId) {
		customerId(customerId).planId(planId);
	}

	public SubscriptionRequest(Customer customer, Plan plan) {
		customer(customer).plan(plan);
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

	public ShippingRequest getShipping() {
		return shipping;
	}

	public BillingRequest getBilling() {
		return billing;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public SubscriptionRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public SubscriptionRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public SubscriptionRequest planId(String planId) {
		this.planId = planId;
		return this;
	}

	public SubscriptionRequest plan(Plan plan) {
		return planId(plan.getId());
	}

	public SubscriptionRequest card(CardRequest card) {
		this.card = card;
		return this;
	}

	public SubscriptionRequest trailEnd(Long trialEnd) {
		this.trialEnd = trialEnd;
		return this;
	}

	public SubscriptionRequest quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public SubscriptionRequest captureCharges(Boolean captureCharges) {
		this.captureCharges = captureCharges;
		return this;
	}

	public SubscriptionRequest shipping(ShippingRequest shipping) {
		this.shipping = shipping;
		return this;
	}

	public SubscriptionRequest billing(BillingRequest billing) {
		this.billing = billing;
		return this;
	}

	public SubscriptionRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public SubscriptionRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
