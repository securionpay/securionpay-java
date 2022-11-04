package com.securionpay.request;


public class ChargeFlowRequest {
	private String returnUrl;

	public String getReturnUrl() {
		return returnUrl;
	}

	public ChargeFlowRequest returnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}
}
