package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.enums.BlacklistRuleType;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class BlacklistRuleRequest {

	private BlacklistRuleType ruleType;

	private String fingerprint;
	private String cardNumber;
	private String ipAddress;
	private String ipCountry;
	private String metadataKey;
	private String metadataValue;
	private String email;
	private String userAgent;
	private String acceptLanguage;
	private String cardCountry;
	private String cardBin;
	private String cardIssuer;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public BlacklistRuleRequest() {
	}

	public BlacklistRuleRequest(BlacklistRuleType ruleType) {
		this.ruleType = ruleType;
	}

	public BlacklistRuleType getRuleType() {
		return ruleType;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getIpCountry() {
		return ipCountry;
	}

	public String getMetadataKey() {
		return metadataKey;
	}

	public String getMetadataValue() {
		return metadataValue;
	}

	public String getEmail() {
		return email;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public String getCardCountry() {
		return cardCountry;
	}

	public String getCardBin() {
		return cardBin;
	}

	public String getCardIssuer() {
		return cardIssuer;
	}

	public BlacklistRuleRequest ruleType(BlacklistRuleType ruleType) {
		this.ruleType = ruleType;
		return this;
	}

	public BlacklistRuleRequest fingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
		return this;
	}

	public BlacklistRuleRequest cardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		return this;
	}

	public BlacklistRuleRequest ipAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		return this;
	}

	public BlacklistRuleRequest ipCountry(String ipCountry) {
		this.ipCountry = ipCountry;
		return this;
	}

	public BlacklistRuleRequest metadataKey(String metadataKey) {
		this.metadataKey = metadataKey;
		return this;
	}

	public BlacklistRuleRequest metadataValue(String metadataValue) {
		this.metadataValue = metadataValue;
		return this;
	}

	public BlacklistRuleRequest email(String email) {
		this.email = email;
		return this;
	}

	public BlacklistRuleRequest userAgent(String userAgent) {
		this.userAgent = userAgent;
		return this;
	}

	public BlacklistRuleRequest acceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
		return this;
	}

	public BlacklistRuleRequest cardCountry(String cardCountry) {
		this.cardCountry = cardCountry;
		return this;
	}

	public BlacklistRuleRequest cardBin(String cardBin) {
		this.cardBin = cardBin;
		return this;
	}

	public BlacklistRuleRequest cardIssuer(String cardIssuer) {
		this.cardIssuer = cardIssuer;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public BlacklistRuleRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
