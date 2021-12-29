package com.securionpay.response;

import com.securionpay.enums.ErrorCode;
import com.securionpay.enums.ErrorType;

public class ErrorResponse {

	private ErrorData error;

	public String getMessage() {
		return error.getMessage();
	}

	public ErrorType getType() {
		return error.getType();
	}

	public ErrorCode getCode() {
		return error.getCode();
	}

	public String getIssuerDeclineCode() {
		return error.getIssuerDeclineCode();
	}

	public String getChargeId() {
		return error.getChargeId();
	}

	public String getCreditId() {
		return error.getCreditId();
	}

	public String getBlacklistRuleId() {
		return error.getBlacklistRuleId();
	}

	public String getAlertRuleId() {
		return error.getAlertRuleId();
	}

	public String getAlertId() {
		return error.getAlertId();
	}

	public static class ErrorData {

		private String message;
		private ErrorType type;
		private ErrorCode code;
		private String issuerDeclineCode;
		private String chargeId;
		private String creditId;
		private String blacklistRuleId;
		private String alertRuleId;
		private String alertId;

		public String getMessage() {
			return message;
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

		public String getAlertRuleId() {
			return alertRuleId;
		}

		public String getAlertId() {
			return alertId;
		}
	}
}
