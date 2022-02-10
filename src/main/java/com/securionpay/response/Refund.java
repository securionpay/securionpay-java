package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Refund {

	private Integer amount;
	private String currency;
	private Long created;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Long getCreated() {
		return created;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
