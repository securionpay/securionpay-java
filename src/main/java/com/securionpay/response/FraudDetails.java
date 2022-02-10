package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.FraudStatus;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class FraudDetails {

	private String status;
	private Integer score;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public FraudStatus getStatus() {
		return FraudStatus.fromValue(status);
	}

	public String getStatusAsString() {
		return status;
	}

	public Integer getScore() {
		return score;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
