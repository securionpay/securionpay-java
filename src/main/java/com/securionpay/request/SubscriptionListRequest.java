package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;
import com.securionpay.response.Subscription;

@JsonInclude(Include.NON_NULL)
public class SubscriptionListRequest {

	@JsonIgnore
	private String customerId;

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;
	private Boolean deleted;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public SubscriptionListRequest() {
	}

	public SubscriptionListRequest(String customerId) {
		customerId(customerId);
	}

	public SubscriptionListRequest(Customer customer) {
		customer(customer);
	}

	public String getCustomerId() {
		return customerId;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public SubscriptionListRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public SubscriptionListRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public SubscriptionListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public SubscriptionListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public SubscriptionListRequest startingAfter(Subscription subscription) {
		return startingAfterId(subscription.getId());
	}

	public SubscriptionListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public SubscriptionListRequest endingBefore(Subscription subscription) {
		return endingBeforeId(subscription.getId());
	}

	public SubscriptionListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public SubscriptionListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public SubscriptionListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public SubscriptionListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public SubscriptionListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
