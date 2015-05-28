package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Charge;

@JsonInclude(Include.NON_EMPTY)
public class ChargeUpdateRequest {

	@JsonIgnore
	private String chargeId;

	private String description;
	private String customerId;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

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
