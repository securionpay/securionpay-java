package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.response.CrossSaleOffer;

@JsonInclude(Include.NON_NULL)
public class CrossSaleOfferListRequest {

	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;

	private CreatedFilter created;
	private Boolean deleted;

	private String partnerId;

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

	public String getPartnerId() {
		return partnerId;
	}

	public CrossSaleOfferListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public CrossSaleOfferListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public CrossSaleOfferListRequest startingAfter(CrossSaleOffer crossSaleOffer) {
		return startingAfterId(crossSaleOffer.getId());
	}

	public CrossSaleOfferListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public CrossSaleOfferListRequest endingBefore(CrossSaleOffer crossSaleOffer) {
		return endingBeforeId(crossSaleOffer.getId());
	}

	public CrossSaleOfferListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public CrossSaleOfferListRequest includeTotalCount() {
		return includeTotalCount(true);
	}

	public CrossSaleOfferListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	public CrossSaleOfferListRequest deleted(Boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	public CrossSaleOfferListRequest partnerId(String partnerId) {
		this.partnerId = partnerId;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CrossSaleOfferListRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
