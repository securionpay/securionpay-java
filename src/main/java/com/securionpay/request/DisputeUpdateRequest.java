package com.securionpay.request;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_NULL)
public class DisputeUpdateRequest {

	private DisputeEvidenceRequest evidence;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();

	public DisputeEvidenceRequest getEvidence() {
		return evidence;
	}

	public DisputeUpdateRequest evidence(DisputeEvidenceRequest evidence) {
		this.evidence = evidence;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public DisputeUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
