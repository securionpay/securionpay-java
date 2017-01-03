package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.enums.FraudStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FraudDetailsRequest {
	private FraudStatus status;

	public FraudStatus getStatus() {
		return status;
	}

	public FraudDetailsRequest status(FraudStatus status) {
		this.status = status;
		return this;
	}

	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public FraudDetailsRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
