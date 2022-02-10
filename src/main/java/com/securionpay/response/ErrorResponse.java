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

	public String getTypeAsString() {
		return error.getCodeAsString();
	}

	public ErrorCode getCode() {
		return error.getCode();
	}

	public String getCodeAsString() {
		return error.getCodeAsString();
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
		private String type;
		private String code;
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
			return ErrorType.fromValue(type);
		}

		public String getTypeAsString() {
			return type;
		}

		public ErrorCode getCode() {
			return ErrorCode.fromValue(code);
		}

		public String getCodeAsString() {
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
