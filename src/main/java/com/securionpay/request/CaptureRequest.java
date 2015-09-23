package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Charge;

@JsonInclude(Include.NON_NULL)
public class CaptureRequest {

	@JsonIgnore
	private String chargeId;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CaptureRequest() {
	}

	public CaptureRequest(String chargeId) {
		chargeId(chargeId);
	}

	public CaptureRequest(Charge charge) {
		charge(charge);
	}

	public String getChargeId() {
		return chargeId;
	}

	public CaptureRequest chargeId(String chargeId) {
		this.chargeId = chargeId;
		return this;
	}

	public CaptureRequest charge(Charge charge) {
		return chargeId(charge.getId());
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CaptureRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
