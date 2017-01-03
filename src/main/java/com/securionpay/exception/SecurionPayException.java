package com.securionpay.exception;

import com.securionpay.enums.ErrorCode;
import com.securionpay.enums.ErrorType;
import com.securionpay.response.ErrorResponse;

public class SecurionPayException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorType type;
	private final ErrorCode code;
	private final String issuerDeclineCode;
	private final String chargeId;
	private final String creditId;
	private final String blacklistRuleId;

	public SecurionPayException(String message, ErrorType type, ErrorCode code, String issuerDeclineCode, String chargeId, String creditId, String blacklistRuleId) {
		super(message);

		this.type = type;
		this.code = code;
		this.issuerDeclineCode = issuerDeclineCode;
		this.chargeId = chargeId;
		this.creditId = creditId;
		this.blacklistRuleId = blacklistRuleId;
	}

	public SecurionPayException(ErrorResponse error) {
		this(error.getMessage(), error.getType(), error.getCode(), error.getIssuerDeclineCode(), error.getChargeId(), error.getCreditId(), error.getBlacklistRuleId());
	}

	public ErrorType getType() {
		return type;
	}

	public ErrorCode getCode() {
		return code;
	}

	public String getIssuerDeclineCode() {
		return issuerDeclineCode;
	}

	public String getChargeId() {
		return chargeId;
	}

	public String getCreditId() {
		return creditId;
	}

	public String getBlacklistRuleId() {
		return blacklistRuleId;
	}
}
