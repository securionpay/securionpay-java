package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class DisputeEvidence {
	private String productDescription;
	private String customerName;
	private String customerEmail;
	private String customerPurchaseIp;
	private String customerSignature;
	private String billingAddress;
	private String receipt;
	private String customerCommunication;

	private String serviceDate;
	private String serviceDocumentation;

	private String duplicateChargeId;
	private String duplicateChargeDocumentation;
	private String duplicateChargeExplanation;

	private String refundPolicy;
	private String refundPolicyDisclosure;
	private String refundRefusalExplanation;

	private String cancellationPolicy;
	private String cancellationPolicyDisclosure;
	private String cancellationRefusalExplanation;

	private String accessActivityLogs;

	private String shippingAddress;
	private String shippingDate;
	private String shippingCarrier;
	private String shippingTrackingNumber;
	private String shippingDocumentation;

	private String uncategorizedText;
	private String uncategorizedFile;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getProductDescription() {
		return productDescription;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String getCustomerPurchaseIp() {
		return customerPurchaseIp;
	}

	public String getCustomerSignature() {
		return customerSignature;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public String getReceipt() {
		return receipt;
	}

	public String getCustomerCommunication() {
		return customerCommunication;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public String getServiceDocumentation() {
		return serviceDocumentation;
	}

	public String getDuplicateChargeId() {
		return duplicateChargeId;
	}

	public String getDuplicateChargeDocumentation() {
		return duplicateChargeDocumentation;
	}

	public String getDuplicateChargeExplanation() {
		return duplicateChargeExplanation;
	}

	public String getRefundPolicy() {
		return refundPolicy;
	}

	public String getRefundPolicyDisclosure() {
		return refundPolicyDisclosure;
	}

	public String getRefundRefusalExplanation() {
		return refundRefusalExplanation;
	}

	public String getCancellationPolicy() {
		return cancellationPolicy;
	}

	public String getCancellationPolicyDisclosure() {
		return cancellationPolicyDisclosure;
	}

	public String getCancellationRefusalExplanation() {
		return cancellationRefusalExplanation;
	}

	public String getAccessActivityLogs() {
		return accessActivityLogs;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public String getShippingCarrier() {
		return shippingCarrier;
	}

	public String getShippingTrackingNumber() {
		return shippingTrackingNumber;
	}

	public String getShippingDocumentation() {
		return shippingDocumentation;
	}

	public String getUncategorizedText() {
		return uncategorizedText;
	}

	public String getUncategorizedFile() {
		return uncategorizedFile;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
