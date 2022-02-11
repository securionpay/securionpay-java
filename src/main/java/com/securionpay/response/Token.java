package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.CardBrand;
import com.securionpay.enums.CardType;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Token {

	private String id;
	private Long created;

	private String first6;
	private String last4;
	private String fingerprint;

	private String expMonth;
	private String expYear;

	private String brand;
	private String type;

	private String cardholderName;
	private Boolean used;
	private Card card;

	private String addressLine1;
	private String addressLine2;
	private String addressCity;
	private String addressState;
	private String addressZip;
	private String addressCountry;

	private FraudCheckData fraudCheckData;
	private ThreeDSecureInfo threeDSecureInfo;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public String getFirst6() {
		return first6;
	}

	public String getLast4() {
		return last4;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public CardBrand getBrand() {
		return CardBrand.fromValue(brand);
	}

	public String getBrandAsString() {
		return brand;
	}

	public CardType getType() {
		return CardType.fromValue(type);
	}

	public String getTypeAsString() {
		return type;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public Boolean getUsed() {
		return used;
	}

	public Card getCard() {
		return card;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public String getAddressZip() {
		return addressZip;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public FraudCheckData getFraudCheckData() {
		return fraudCheckData;
	}

	public ThreeDSecureInfo getThreeDSecureInfo() {
		return threeDSecureInfo;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
