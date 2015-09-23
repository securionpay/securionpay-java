package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.enums.Interval;

@JsonInclude(Include.NON_NULL)
public class PlanRequest {

	private Integer amount;
	private String currency;
	private Interval interval;
	private Integer intervalCount;
	private String name;
	private Integer trialPeriodDays;
	private String statementDescription;
	private Map<String, String> metadata;
	private Integer billingCycles;
	private String recursTo;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public PlanRequest() {
	}

	public PlanRequest(Integer amount, String currency, Interval interval, String name) {
		amount(amount).currency(currency).interval(interval).name(name);
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Interval getInterval() {
		return interval;
	}

	public Integer getIntervalCount() {
		return intervalCount;
	}

	public String getName() {
		return name;
	}

	public Integer getTrialPeriodDays() {
		return trialPeriodDays;
	}

	public String getStatementDescription() {
		return statementDescription;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public Integer getBillingCycles() {
		return billingCycles;
	}

	public String getRecursTo() {
		return recursTo;
	}

	public PlanRequest amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public PlanRequest currency(String currency) {
		this.currency = currency;
		return this;
	}

	public PlanRequest interval(Interval interval) {
		this.interval = interval;
		return this;
	}

	public PlanRequest name(String name) {
		this.name = name;
		return this;
	}

	public PlanRequest intervalCount(Integer intervalCount) {
		this.intervalCount = intervalCount;
		return this;
	}

	public PlanRequest trialPeriodDays(Integer trialPeriodDays) {
		this.trialPeriodDays = trialPeriodDays;
		return this;
	}

	public PlanRequest statementDescription(String statementDescription) {
		this.statementDescription = statementDescription;
		return this;
	}

	public PlanRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	public PlanRequest billingCycles(Integer billingCycles) {
		this.billingCycles = billingCycles;
		return this;
	}

	public PlanRequest recursTo(String planId) {
		this.recursTo = planId;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public PlanRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
