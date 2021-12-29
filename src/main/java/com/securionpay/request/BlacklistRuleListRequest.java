package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.BlacklistRule;

@JsonInclude(Include.NON_NULL)
public class BlacklistRuleListRequest {

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;
	private Boolean deleted;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

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

	public BlacklistRuleListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public BlacklistRuleListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public BlacklistRuleListRequest startingAfter(BlacklistRule blacklistRule) {
		return startingAfterId(blacklistRule.getId());
	}

	public BlacklistRuleListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public BlacklistRuleListRequest endingBefore(BlacklistRule blacklistRule) {
		return endingBeforeId(blacklistRule.getId());
	}

	public BlacklistRuleListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public BlacklistRuleListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public BlacklistRuleListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public BlacklistRuleListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public BlacklistRuleListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
