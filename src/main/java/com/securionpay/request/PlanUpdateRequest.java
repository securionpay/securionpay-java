package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Plan;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class PlanUpdateRequest {

	@JsonIgnore
	private String planId;

	private Integer amount;
	private String currency;

	private String name;
	private Map<String, String> metadata;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public PlanUpdateRequest() {
	}

	public PlanUpdateRequest(String planId) {
		planId(planId);
	}

	public PlanUpdateRequest(Plan plan) {
		plan(plan);
	}

	public String getPlanId() {
		return planId;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public String getCurrency() {
		return currency;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public PlanUpdateRequest planId(String planId) {
		this.planId = planId;
		return this;
	}

	public PlanUpdateRequest plan(Plan plan) {
		return planId(plan.getId());
	}

	public PlanUpdateRequest amount(Integer amount) {
		this.amount = amount;
		return this;
	}

	public PlanUpdateRequest currency(String currency) {
		this.currency = currency;
		return this;
	}
	
	public PlanUpdateRequest name(String name) {
		this.name = name;
		return this;
	}

	public PlanUpdateRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public PlanUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
