package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.Card;
import com.securionpay.response.Customer;

@JsonInclude(Include.NON_EMPTY)
public class CardListRequest {

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

	public CardListRequest() {
	}

	public CardListRequest(String customerId) {
		customerId(customerId);
	}

	public CardListRequest(Customer customer) {
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

	public CardListRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CardListRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public CardListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CardListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CardListRequest startingAfter(Card card) {
		return startingAfterId(card.getId());
	}

	public CardListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CardListRequest endingBefore(Card card) {
		return endingBeforeId(card.getId());
	}

	public CardListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CardListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CardListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public CardListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CardListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
