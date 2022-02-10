package com.securionpay.response;

import com.securionpay.enums.FraudStatus;

public class FraudDetails {

	private String status;
	private Integer score;

	public FraudStatus getStatus() {
		return FraudStatus.fromValue(status);
	}

	public String getStatusAsString() {
		return status;
	}

	public Integer getScore() {
		return score;
	}
}
