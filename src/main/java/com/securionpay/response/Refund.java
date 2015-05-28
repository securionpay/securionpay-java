package com.securionpay.response;

public class Refund {

	private Integer amount;
	private String currency;
	private Long created;

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Long getCreated() {
		return created;
	}
}
