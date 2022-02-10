package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.Interval;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Plan {

	private String id;
	private Long created;
	private boolean deleted = false;

	private Integer amount;
	private String currency;
	private String interval;
	private Integer intervalCount;
	private Integer billingCycles;
	private String name;
	private Integer trialPeriodDays;
	private String recursTo;
	private String statementDescription;
	private Map<String, String> metadata;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Interval getInterval() {
		return Interval.fromValue(interval);
	}

	public String getIntervalAsString() {
		return interval;
	}

	public Integer getIntervalCount() {
		return intervalCount;
	}

	public Integer getBillingCycles() {
		return billingCycles;
	}

	public String getName() {
		return name;
	}

	public Integer getTrialPeriodDays() {
		return trialPeriodDays;
	}

	public String getRecursTo() {
		return recursTo;
	}

	public String getStatementDescription() {
		return statementDescription;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
