package com.securionpay.exception;

import com.securionpay.enums.ErrorCode;
import com.securionpay.enums.ErrorType;
import com.securionpay.response.ErrorResponse;

public class SecurionPayException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorType type;
	private final ErrorCode code;
	private final String chargeId;
	private final String blacklistRuleId;

	public SecurionPayException(String message, ErrorType type, ErrorCode code, String chargeId, String blacklistRuleId) {
		super(message);

		this.type = type;
		this.code = code;
		this.chargeId = chargeId;
		this.blacklistRuleId = blacklistRuleId;
	}

	public SecurionPayException(ErrorResponse error) {
		this(error.getMessage(), error.getType(), error.getCode(), error.getChargeId(), error.getBlacklistRuleId());
	}

	public ErrorType getType() {
		return type;
	}

	public ErrorCode getCode() {
		return code;
	}

	public String getChargeId() {
		return chargeId;
	}

	public String getBlacklistRuleId() {
		return blacklistRuleId;
	}
}
