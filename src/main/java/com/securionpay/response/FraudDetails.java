package com.securionpay.response;

import com.securionpay.enums.FraudStatus;

public class FraudDetails {

	private FraudStatus status;
	private Integer score;

	public FraudStatus getStatus() {
		return status;
	}

	public Integer getScore() {
		return score;
	}
}
