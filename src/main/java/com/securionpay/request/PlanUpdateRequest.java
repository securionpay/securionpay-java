package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Plan;

@JsonInclude(Include.NON_NULL)
public class PlanUpdateRequest {

	@JsonIgnore
	private String planId;

	private String name;
	private String statementDescription;
	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

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

	public String getName() {
		return name;
	}

	public String getStatementDescription() {
		return statementDescription;
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

	public PlanUpdateRequest name(String name) {
		this.name = name;
		return this;
	}

	public PlanUpdateRequest statementDescription(String statementDescription) {
		this.statementDescription = statementDescription;
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
