package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.CustomerRecord;
import com.securionpay.response.CustomerRecordProfit;

@JsonInclude(Include.NON_NULL)
public class CustomerRecordProfitListRequest {

	@JsonIgnore
	private String customerRecordId;

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CustomerRecordProfitListRequest() {
	}

	public CustomerRecordProfitListRequest(String customerRecordId) {
		customerRecordId(customerRecordId);
	}

	public CustomerRecordProfitListRequest(CustomerRecord customerRecord) {
		customerRecord(customerRecord);
	}

	public String getCustomerRecordId() {
		return customerRecordId;
	}

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

	public CustomerRecordProfitListRequest customerRecordId(String customerRecordId) {
		this.customerRecordId = customerRecordId;
		return this;
	}

	public CustomerRecordProfitListRequest customerRecord(CustomerRecord customerRecord) {
		return customerRecordId(customerRecord.getId());
	}

	public CustomerRecordProfitListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CustomerRecordProfitListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CustomerRecordProfitListRequest startingAfter(CustomerRecordProfit customerRecordProfit) {
		return startingAfterId(customerRecordProfit.getId());
	}

	public CustomerRecordProfitListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CustomerRecordProfitListRequest endingBefore(CustomerRecordProfit customerRecordProfit) {
		return endingBeforeId(customerRecordProfit.getId());
	}

	public CustomerRecordProfitListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CustomerRecordProfitListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CustomerRecordProfitListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CustomerRecordProfitListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
