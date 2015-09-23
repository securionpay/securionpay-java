package com.securionpay.request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CheckoutRequest {

	private Charge charge;
	private Subscription subscription;

	private String customerId;
	private List<String> crossSaleOfferIds;
	private Boolean rememberMe;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CheckoutRequest() {
	}

	public CheckoutRequest(Integer amount, String currency) {
		charge(amount, currency);
	}

	public CheckoutRequest(String planId) {
		subscription(planId);
	}

	public Charge getCharge() {
		return charge;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<String> getCrossSaleOfferIds() {
		return crossSaleOfferIds;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public CheckoutRequest charge(Charge charge) {
		this.charge = charge;
		return this;
	}

	public CheckoutRequest charge(Integer amount, String currency) {
		return charge(new Charge(amount, currency));
	}

	public CheckoutRequest subscription(Subscription subscription) {
		this.subscription = subscription;
		return this;
	}

	public CheckoutRequest subscription(String planId) {
		return subscription(new Subscription(planId));
	}

	public CheckoutRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CheckoutRequest crossSaleOfferIds(String... crossSaleOfferIds) {
		return crossSaleOfferIds(Arrays.asList(crossSaleOfferIds));
	}

	public CheckoutRequest crossSaleOfferIds(List<String> crossSaleOfferIds) {
		this.crossSaleOfferIds = crossSaleOfferIds;
		return this;
	}

	public CheckoutRequest rememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CheckoutRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}

	@JsonInclude(Include.NON_NULL)
	public static class Charge {

		private Integer amount;
		private String currency;
		private Boolean capture;

		@JsonIgnore
		private Map<String, Object> other = new HashMap<String, Object>();

		public Charge() {
		}

		public Charge(Integer amount, String currency) {
			this.amount = amount;
			this.currency = currency;
		}

		public Integer getAmount() {
			return amount;
		}

		public String getCurrency() {
			return currency;
		}

		public Boolean getCapture() {
			return capture;
		}

		public Charge amount(Integer amount) {
			this.amount = amount;
			return this;
		}

		public Charge currency(String currency) {
			this.currency = currency;
			return this;
		}

		public Charge capture(Boolean capture) {
			this.capture = capture;
			return this;
		}

		@JsonAnyGetter
		private Map<String, Object> getOtherMap() {
			return other;
		}

		@JsonAnySetter
		public Charge set(String name, Object value) {
			other.put(name, value);
			return this;
		}
	}

	@JsonInclude(Include.NON_NULL)
	public static class Subscription {

		private String planId;
		private Boolean captureCharges;

		@JsonIgnore
		private Map<String, Object> other = new HashMap<String, Object>();

		public Subscription() {
		}

		public Subscription(String planId) {
			this.planId = planId;
		}

		public String getPlanId() {
			return planId;
		}

		public Boolean getCaptureCharges() {
			return captureCharges;
		}

		public Subscription planId(String planId) {
			this.planId = planId;
			return this;
		}

		public Subscription captureCharges(Boolean captureCharges) {
			this.captureCharges = captureCharges;
			return this;
		}

		@JsonAnyGetter
		private Map<String, Object> getOtherMap() {
			return other;
		}

		@JsonAnySetter
		public Subscription set(String name, Object value) {
			other.put(name, value);
			return this;
		}
	}
}
