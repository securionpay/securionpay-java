package com.securionpay.response;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.DisputeReason;
import com.securionpay.enums.DisputeStatus;

public class Dispute {

	private String id;
	private Long created;
	private Long updated;

	private Integer amount;
	private String currency;

	private String status;
	private String reason;

	private Boolean acceptedAsLost;

	private DisputeEvidence evidence;
	private DisputeEvidenceDetails evidenceDetails;

	private Charge charge;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public Long getUpdated() {
		return updated;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public DisputeStatus getStatus() {
		return DisputeStatus.fromValue(status);
	}

	public String getStatusAsString() {
		return status;
	}

	public DisputeReason getReason() {
		return DisputeReason.fromValue(reason);
	}

	public String getReasonAsString() {
		return reason;
	}

	public Boolean getAcceptedAsLost() {
		return acceptedAsLost;
	}

	public DisputeEvidence getEvidence() {
		return evidence;
	}

	public DisputeEvidenceDetails getEvidenceDetails() {
		return evidenceDetails;
	}

	public Charge getCharge() {
		return charge;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
