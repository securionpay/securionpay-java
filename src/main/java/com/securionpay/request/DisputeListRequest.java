package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisputeListRequest {
	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;
	private CreatedFilter created;
	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public DisputeListRequest() {
	}

	public Integer getLimit() {
		return this.limit;
	}

	public String getStartingAfterId() {
		return this.startingAfterId;
	}

	public String getEndingBeforeId() {
		return this.endingBeforeId;
	}

	public Boolean getIncludeTotalCount() {
		return this.includeTotalCount;
	}

	public CreatedFilter getCreated() {
		return this.created;
	}

	public DisputeListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public DisputeListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public DisputeListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public DisputeListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public DisputeListRequest includeTotalCount() {
		return this.includeTotalCount(Boolean.TRUE);
	}

	public DisputeListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return this.other;
	}

	@JsonAnySetter
	public DisputeListRequest set(String name, Object value) {
		this.other.put(name, value);
		return this;
	}
}