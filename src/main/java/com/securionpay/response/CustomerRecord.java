package com.securionpay.response;

public class CustomerRecord {
	private String id;
	private String email;

	private Long created;
	private Long updated;
	private boolean subscription;
	private boolean latest;

	private Integer volume;
	private String currency;
	private Integer chargesCount;
	private Integer refundsCount;
	private Integer chargebacksCount;
	private boolean verifiedPhone;

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Long getCreated() {
		return created;
	}

	public Long getUpdated() {
		return updated;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public boolean isLatest() {
		return latest;
	}

	public Integer getVolume() {
		return volume;
	}

	public String getCurrency() {
		return currency;
	}

	public Integer getChargesCount() {
		return chargesCount;
	}

	public Integer getRefundsCount() {
		return refundsCount;
	}

	public Integer getChargebacksCount() {
		return chargebacksCount;
	}

	public boolean isVerifiedPhone() {
		return verifiedPhone;
	}
}