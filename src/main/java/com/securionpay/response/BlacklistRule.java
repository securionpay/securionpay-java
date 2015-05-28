package com.securionpay.response;

import com.securionpay.enums.BlacklistRuleType;

public class BlacklistRule {

	private String id;
	private Long created;
	private boolean deleted = false;

	private BlacklistRuleType ruleType;

	private String fingerprint;
	private String ipAddress;
	private String ipCountry;
	private String metadataKey;
	private String metadataValue;
	private String email;
	private String userAgent;
	private String acceptLanguage;

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public BlacklistRuleType getRuleType() {
		return ruleType;
	}

	public String getFingerprint() {
		return fingerprint;
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
}
