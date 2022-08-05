package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.SubscriptionStatus;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Subscription {

	private String id;
	private Long created;
	private boolean deleted = false;

	private String planId;
	private String customerId;
	private Integer quantity;
	private Boolean captureCharges;
	private String status;
	private Integer remainingBillingCycles;
	private Long start;
	private Long currentPeriodStart;
	private Long currentPeriodEnd;
	private Long canceledAt;
	private Long endedAt;
	private Long trialStart;
	private Long trialEnd;
	private Boolean cancelAtPeriodEnd;
	private Shipping shipping;
	private Billing billing;
	private ThreeDSecureInfo threeDSecureInfo;
	private Charge.FromCrossSale fromCrossSale;
	private String merchantAccountId;
	private Map<String, String> metadata;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public String getPlanId() {
		return planId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Boolean getCaptureCharges() {
		return captureCharges;
	}

	public SubscriptionStatus getStatus() {
		return SubscriptionStatus.fromValue(status);
	}

	public String getStatusAsString() {
		return status;
	}

	public Integer getRemainingBillingCycles() {
		return remainingBillingCycles;
	}

	public Long getStart() {
		return start;
	}

	public Long getCurrentPeriodStart() {
		return currentPeriodStart;
	}

	public Long getCurrentPeriodEnd() {
		return currentPeriodEnd;
	}

	public Long getCanceledAt() {
		return canceledAt;
	}

	public Long getEndedAt() {
		return endedAt;
	}

	public Long getTrialStart() {
		return trialStart;
	}

	public Long getTrialEnd() {
		return trialEnd;
	}

	public Boolean getCancelAtPeriodEnd() {
		return cancelAtPeriodEnd;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public Billing getBilling() {
		return billing;
	}

	public ThreeDSecureInfo getThreeDSecureInfo() {
		return threeDSecureInfo;
	}

	public Charge.FromCrossSale getFromCrossSale() {
		return fromCrossSale;
	}

	public String getMerchantAccountId() {
		return merchantAccountId;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public String get(String name) {
		if ("merchantAccountId".equals(name)) {
			return merchantAccountId;
		}

		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
