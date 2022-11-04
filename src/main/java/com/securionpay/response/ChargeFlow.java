package com.securionpay.response;

import com.securionpay.enums.ChargeFlowActionType;

public class ChargeFlow {

	private ChargeFlowActionType nextAction;
	private Redirect redirect;
	private String returnUrl;

	public ChargeFlowActionType getNextAction() {
		return nextAction;
	}

	public Redirect getRedirect() {
		return redirect;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public ChargeFlow nextAction(ChargeFlowActionType nextAction) {
		this.nextAction = nextAction;
		return this;
	}

	public ChargeFlow redirect(Redirect redirect) {
		this.redirect = redirect;
		return this;
	}

	public ChargeFlow returnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}

	public static class Redirect {
		private String redirectUrl;

		public String getRedirectUrl() {
			return redirectUrl;
		}

		public Redirect redirectUrl(String redirectUrl) {
			this.redirectUrl = redirectUrl;
			return this;
		}
	}
}
