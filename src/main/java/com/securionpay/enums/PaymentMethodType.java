package com.securionpay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethodType {
	ALIPAY("alipay"),
	BANCONTACT("bancontact"),
	BLIK("blik"),
	BOLETO("boleto"),
	EPS("eps"),
	ESTONIANBANKS("estonianbanks"),
	GIROPAY("giropay"),
	IDEAL("ideal"),
	LATVIANBANKS("latvianbanks"),
	LITHUANIANBANKS("lithuanianbanks"),
	MULTIBANCO("multibanco"),
	MYBANK("mybank"),
	P24("p24"),
	PAYSAFECARD("paysafecard"),
	PAYSAFECASH("paysafecash"),
	PAYSERA("paysera"),
	PAYU("payu"),
	POLI("poli"),
	SKRILL("skrill"),
	SOFORT("sofort"),
	TRUSTLY("trustly"),
	UNIONPAY("unionpay"),
	VERKKOPANKKI("verkkopankki"),
	WECHATPAY("wechatpay"),

	/**
	 * Used when received value can't be mapped to this enumeration.
	 */
	UNRECOGNIZED("unrecognized");

	private final String value;

	PaymentMethodType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static PaymentMethodType fromValue(String value) {
		if (value == null) {
			return null;
		}
		for (PaymentMethodType type : values()) {
			if (type.value.equalsIgnoreCase(value)) {
				return type;
			}
		}

		return UNRECOGNIZED;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
