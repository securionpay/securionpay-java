package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;

@JsonInclude(Include.NON_EMPTY)
public class CustomerListRequest {

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

	public CustomerListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CustomerListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CustomerListRequest startingAfter(Customer customer) {
		return startingAfterId(customer.getId());
	}

	public CustomerListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CustomerListRequest endingBefore(Customer customer) {
		return endingBeforeId(customer.getId());
	}

	public CustomerListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CustomerListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CustomerListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public CustomerListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CustomerListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
