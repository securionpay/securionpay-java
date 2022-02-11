package com.securionpay.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class DisputeEvidenceDetails {
	private Long dueBy;
	private boolean hasEvidence;
	private boolean pastDue;
	private Integer submissionCount;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public Long getDueBy() {
		return dueBy;
	}

	public boolean isHasEvidence() {
		return hasEvidence;
	}

	public boolean isPastDue() {
		return pastDue;
	}

	public Integer getSubmissionCount() {
		return submissionCount;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
