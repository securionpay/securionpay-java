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
public class RefundRequest {

	@JsonIgnore
	private String chargeId;

	private Integer amount;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public RefundRequest() {
	}

	public RefundRequest(String chargeId) {
		chargeId(chargeId);
	}

	public RefundRequest(Charge charge) {
		charge(charge);
	}

	public String getChargeId() {
		return chargeId;
	}

	public Integer getAmount() {
		return amount;
	}

	public RefundRequest chargeId(String chargeId) {
		this.chargeId = chargeId;
		return this;
	}

	public RefundRequest charge(Charge charge) {
		return chargeId(charge.getId());
	}

	public RefundRequest amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public RefundRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
