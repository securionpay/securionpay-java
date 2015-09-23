package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.CustomerRecord;

@JsonInclude(Include.NON_NULL)
public class CustomerRecordListRequest {

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;

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

	public CustomerRecordListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CustomerRecordListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CustomerRecordListRequest startingAfter(CustomerRecord customerRecord) {
		return startingAfterId(customerRecord.getId());
	}

	public CustomerRecordListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CustomerRecordListRequest endingBefore(CustomerRecord customerRecord) {
		return endingBeforeId(customerRecord.getId());
	}

	public CustomerRecordListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CustomerRecordListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CustomerRecordListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CustomerRecordListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
