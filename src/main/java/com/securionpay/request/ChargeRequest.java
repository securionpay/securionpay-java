package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;

@JsonInclude(Include.NON_NULL)
public class ChargeRequest {

	private Integer amount;
	private String currency;
	private String description;
	private String customerId;
	private CardRequest card;
	private Boolean captured;
	private ShippingRequest shipping;
	private BillingRequest billing;
	private ThreeDSecureRequest threeDSecure;
	private String merchantAccountId;
	private Map<String, String> metadata;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public ChargeRequest() {
	}

	public ChargeRequest(Integer amount, String currency) {
		amount(amount).currency(currency);
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getDescription() {
		return description;
	}

	public String getCustomerId() {
		return customerId;
	}

	public CardRequest getCard() {
		return card;
	}

	public Boolean getCaptured() {
		return captured;
	}

	public BillingRequest getBilling() {
		return billing;
	}

	public ShippingRequest getShipping() {
		return shipping;
	}

	public ThreeDSecureRequest getThreeDSecure() {
		return threeDSecure;
	}

	public String getMerchantAccountId() {
		return merchantAccountId;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public ChargeRequest amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public ChargeRequest currency(String currency) {
		this.currency = currency;
		return this;
	}

	public ChargeRequest description(String description) {
		this.description = description;
		return this;
	}

	public ChargeRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public ChargeRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public ChargeRequest card(CardRequest card) {
		this.card = card;
		return this;
	}

	public ChargeRequest captured(Boolean captured) {
		this.captured = captured;
		return this;
	}

	public ChargeRequest shipping(ShippingRequest shipping) {
		this.shipping = shipping;
		return this;
	}

	public ChargeRequest billing(BillingRequest billing) {
		this.billing = billing;
		return this;
	}

	public ChargeRequest threeDSecure(ThreeDSecureRequest threeDSecure) {
		this.threeDSecure = threeDSecure;
		return this;
	}

	public ChargeRequest merchantAccountId(String merchantAccountId) {
		this.merchantAccountId = merchantAccountId;
		return this;
	}

	public ChargeRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ChargeRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
