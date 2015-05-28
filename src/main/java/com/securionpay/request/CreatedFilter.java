package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class CreatedFilter {

	private Long gt;
	private Long gte;
	private Long lt;
	private Long lte;

	public Long getGt() {
		return gt;
	}

	public Long getGte() {
		return gte;
	}

	public Long getLt() {
		return lt;
	}

	public Long getLte() {
		return lte;
	}

	public CreatedFilter gt(Long gt) {
		this.gt = gt;
		return this;
	}

	public CreatedFilter gte(Long gte) {
		this.gte = gte;
		return this;
	}

	public CreatedFilter lt(Long lt) {
		this.lt = lt;
		return this;
	}

	public CreatedFilter lte(Long lte) {
		this.lte = lte;
		return this;
	}
}
