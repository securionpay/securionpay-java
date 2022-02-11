package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.response.Credit;
import com.securionpay.response.Customer;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class CreditListRequest {
	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;

	private String customerId;

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

	public String getCustomerId() {
		return customerId;
	}

	public CreditListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CreditListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CreditListRequest startingAfter(Credit credit) {
		return startingAfterId(credit.getId());
	}

	public CreditListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CreditListRequest endingBefore(Credit credit) {
		return endingBeforeId(credit.getId());
	}

	public CreditListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CreditListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CreditListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public CreditListRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CreditListRequest customer(Customer customer) {
		return customerId(customer.getId());
	}


	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CreditListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
