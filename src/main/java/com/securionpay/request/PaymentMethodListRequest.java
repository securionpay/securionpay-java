package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Customer;
import com.securionpay.response.PaymentMethod;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class PaymentMethodListRequest {

	private String customerId;
	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;
	private Boolean deleted;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public PaymentMethodListRequest() {
	}

	public PaymentMethodListRequest(String customerId) {
		customerId(customerId);
	}

	public PaymentMethodListRequest(Customer customer) {
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

	public PaymentMethodListRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public PaymentMethodListRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public PaymentMethodListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public PaymentMethodListRequest startingAfter(PaymentMethod startingAfter) {
		return startingAfterId(startingAfter.getId());
	}

	public PaymentMethodListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public PaymentMethodListRequest endingBefore(PaymentMethod endingBefore) {
		return endingBeforeId(endingBefore.getId());
	}

	public PaymentMethodListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public PaymentMethodListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public PaymentMethodListRequest includeTotalCount() {
		return this.includeTotalCount(Boolean.TRUE);
	}

	public PaymentMethodListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public PaymentMethodListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public PaymentMethodListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
