package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.enums.PaymentMethodType;
import com.securionpay.response.Customer;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodRequest {
	private String id;
	private String customerId;
	private PaymentMethodType type;
	private BillingRequest billing;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public PaymentMethodRequest() {
	}

	public PaymentMethodRequest(String id) {
		this.id = id;
	}

	public PaymentMethodRequest(PaymentMethodType type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public PaymentMethodType getType() {
		return type;
	}

	public BillingRequest getBilling() {
		return billing;
	}

	public PaymentMethodRequest id(String id) {
		this.id = id;
		return this;
	}

	public PaymentMethodRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public PaymentMethodRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public PaymentMethodRequest type(PaymentMethodType type) {
		this.type = type;
		return this;
	}

	public PaymentMethodRequest billing(BillingRequest billing) {
		this.billing = billing;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public PaymentMethodRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
