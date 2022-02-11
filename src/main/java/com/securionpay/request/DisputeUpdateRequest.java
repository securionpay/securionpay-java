package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.response.Dispute;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class DisputeUpdateRequest {

	@JsonIgnore
	private String disputeId;

	private DisputeEvidenceRequest evidence;

	public DisputeUpdateRequest() {
	}

	public DisputeUpdateRequest(String disputeId) {
		disputeId(disputeId);
	}

	public DisputeUpdateRequest(Dispute dispute) {
		dispute(dispute);
	}

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public DisputeEvidenceRequest getEvidence() {
		return evidence;
	}

	public DisputeUpdateRequest evidence(DisputeEvidenceRequest evidence) {
		this.evidence = evidence;
		return this;
	}

	public String getDisputeId() {
		return disputeId;
	}

	public DisputeUpdateRequest disputeId(String disputeId) {
		this.disputeId = disputeId;
		return this;
	}

	public DisputeUpdateRequest dispute(Dispute dispute) {
		return disputeId(dispute.getId());
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
