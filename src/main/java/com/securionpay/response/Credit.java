package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.ErrorCode;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Credit {
	private String id;
	private Long created;
	private Integer amount;
	private String currency;
	private String description;
	private Card card;
	private String customerId;
	private ThreeDSecureInfo threeDSecureInfo;

	private Map<String, String> metadata;

	private String failureCode;
	private String failureIssuerDeclineCode;
	private String failureMessage;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
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

	public Card getCard() {
		return card;
	}

	public String getCustomerId() {
		return customerId;
	}

	public ThreeDSecureInfo getThreeDSecureInfo() {
		return threeDSecureInfo;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public ErrorCode getFailureCode() {
		return ErrorCode.fromValue(failureCode);
	}

	public String getFailureCodeAsString() {
		return failureCode;
	}

	public String getFailureIssuerDeclineCode() {
		return failureIssuerDeclineCode;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
