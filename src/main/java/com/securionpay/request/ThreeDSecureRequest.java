package com.securionpay.request;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_NULL)
public class ThreeDSecureRequest {
	private Boolean requireAttempt;
	private Boolean requireEnrolledCard;
	private Boolean requireSuccessfulLiabilityShiftForEnrolledCard;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();

	public Boolean getRequireAttempt() {
		return requireAttempt;
	}

	public Boolean getRequireEnrolledCard() {
		return requireEnrolledCard;
	}

	public Boolean getRequireSuccessfulLiabilityShiftForEnrolledCard() {
		return requireSuccessfulLiabilityShiftForEnrolledCard;
	}

	public ThreeDSecureRequest requireAttempt(Boolean requireAttempt) {
		this.requireAttempt = requireAttempt;
		return this;
	}

	public ThreeDSecureRequest requireEnrolledCard(Boolean requireEnrolledCard) {
		this.requireEnrolledCard = requireEnrolledCard;
		return this;
	}

	public ThreeDSecureRequest requireSuccessfulLiabilityShiftForEnrolledCard(Boolean requireSuccessfulLiabilityShiftForEnrolledCard) {
		this.requireSuccessfulLiabilityShiftForEnrolledCard = requireSuccessfulLiabilityShiftForEnrolledCard;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ThreeDSecureRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}