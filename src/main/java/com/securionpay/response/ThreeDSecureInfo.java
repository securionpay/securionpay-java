package com.securionpay.response;

import com.securionpay.enums.AuthenticationFlow;
import com.securionpay.enums.LiabilityShift;

public class ThreeDSecureInfo {
	private Integer amount;
	private String currency;
	private boolean enrolled;
	private LiabilityShift liabilityShift;
	private String version;
	private AuthenticationFlow authenticationFlow;

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public boolean isEnrolled() {
		return enrolled;
	}

	public LiabilityShift getLiabilityShift() {
		return liabilityShift;
	}

	public String getVersion() {
		return version;
	}

	public AuthenticationFlow getAuthenticationFlow() {
		return authenticationFlow;
	}
}
