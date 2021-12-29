package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Charge;
import com.securionpay.response.Customer;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class ChargeUpdateRequest {

	@JsonIgnore
	private String chargeId;

	private String description;
	private String customerId;
	private ShippingRequest shipping;
	private BillingRequest billing;
	private FraudDetailsRequest fraudDetails;
	private Map<String, String> metadata;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public ChargeUpdateRequest() {
	}

	public ChargeUpdateRequest(String chargeId) {
		chargeId(chargeId);
	}

	public ChargeUpdateRequest(Charge charge) {
		charge(charge);
	}

	public String getChargeId() {
		return chargeId;
	}

	public String getDescription() {
		return description;
	}

	public String getCustomerId() {
		return customerId;
	}

	public BillingRequest getBilling() {
		return billing;
	}

	public ShippingRequest getShipping() {
		return shipping;
	}

	public FraudDetailsRequest getFraudDetails() {
		return fraudDetails;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public ChargeUpdateRequest chargeId(String chargeId) {
		this.chargeId = chargeId;
		return this;
	}

	public ChargeUpdateRequest charge(Charge charge) {
		return chargeId(charge.getId());
	}

	public ChargeUpdateRequest description(String description) {
		this.description = description;
		return this;
	}

	public ChargeUpdateRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public ChargeUpdateRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public ChargeUpdateRequest shipping(ShippingRequest shipping) {
		this.shipping = shipping;
		return this;
	}

	public ChargeUpdateRequest billing(BillingRequest billing) {
		this.billing = billing;
		return this;
	}

	public ChargeUpdateRequest fraudDetails(FraudDetailsRequest fraudDetails) {
		this.fraudDetails = fraudDetails;
		return this;
	}

	public ChargeUpdateRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ChargeUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
