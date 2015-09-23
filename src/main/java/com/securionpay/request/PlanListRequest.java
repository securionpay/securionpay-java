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
public class PlanListRequest {

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;
	private Boolean deleted;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public Integer getLimit() {
		return limit;
	}

	public String getStartingAfterId() {
		return startingAfterId;
	}

	public String getEndingBeforeId() {
		return endingBeforeId;
	}

	public Boolean getIncludeTotalCount() {
		return includeTotalCount;
	}

	public CreatedFilter getCreated() {
		return created;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public PlanListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public PlanListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public PlanListRequest startingAfter(Plan plan) {
		return startingAfterId(plan.getId());
	}

	public PlanListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public PlanListRequest endingBefore(Plan plan) {
		return endingBeforeId(plan.getId());
	}

	public PlanListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public PlanListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public PlanListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public PlanListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public PlanListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
