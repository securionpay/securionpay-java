package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.CustomerRecord;
import com.securionpay.response.CustomerRecordFee;

@JsonInclude(Include.NON_NULL)
public class CustomerRecordFeeListRequest {

	@JsonIgnore
	private String customerRecordId;

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CustomerRecordFeeListRequest() {
	}

	public CustomerRecordFeeListRequest(String customerRecordId) {
		customerRecordId(customerRecordId);
	}

	public CustomerRecordFeeListRequest(CustomerRecord customerRecord) {
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

	public CustomerRecordFeeListRequest customerRecordId(String customerRecordId) {
		this.customerRecordId = customerRecordId;
		return this;
	}

	public CustomerRecordFeeListRequest customerRecord(CustomerRecord customerRecord) {
		return customerRecordId(customerRecord.getId());
	}

	public CustomerRecordFeeListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CustomerRecordFeeListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CustomerRecordFeeListRequest startingAfter(CustomerRecordFee customerRecordFee) {
		return startingAfterId(customerRecordFee.getId());
	}

	public CustomerRecordFeeListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CustomerRecordFeeListRequest endingBefore(CustomerRecordFee customerRecordFee) {
		return endingBeforeId(customerRecordFee.getId());
	}

	public CustomerRecordFeeListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CustomerRecordFeeListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CustomerRecordFeeListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CustomerRecordFeeListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
