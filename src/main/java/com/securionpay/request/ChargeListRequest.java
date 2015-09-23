package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Charge;
import com.securionpay.response.Customer;

@JsonInclude(Include.NON_NULL)
public class ChargeListRequest {

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;
	private String customerId;

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

	public String getCustomerId() {
		return customerId;
	}

	public ChargeListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public ChargeListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public ChargeListRequest startingAfter(Charge charge) {
		return startingAfterId(charge.getId());
	}

	public ChargeListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public ChargeListRequest endingBefore(Charge charge) {
		return endingBeforeId(charge.getId());
	}

	public ChargeListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public ChargeListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public ChargeListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public ChargeListRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public ChargeListRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ChargeListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
