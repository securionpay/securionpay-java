package com.securionpay.response;

public class CustomerRecordFee {
	private String id;
	private Long created;
	private Integer amount;
	private String currency;
	private String customerRecordId;

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getCustomerRecordId() {
		return customerRecordId;
	}
}
