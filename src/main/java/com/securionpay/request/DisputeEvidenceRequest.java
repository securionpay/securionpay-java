package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DisputeEvidenceRequest {
	private String productDescription;
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
	private Map<String, Object> other = new HashMap<String, Object>();

	public String getProductDescription() {
		return productDescription;
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

	public DisputeEvidenceRequest productDescription(String productDescription) {
		this.productDescription = productDescription;
		return this;
	}

	public DisputeEvidenceRequest customerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
		return this;
	}

	public DisputeEvidenceRequest customerPurchaseIp(String customerPurchaseIp) {
		this.customerPurchaseIp = customerPurchaseIp;
		return this;
	}

	public DisputeEvidenceRequest customerSignature(String customerSignature) {
		this.customerSignature = customerSignature;
		return this;
	}

	public DisputeEvidenceRequest billingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}

	public DisputeEvidenceRequest receipt(String receipt) {
		this.receipt = receipt;
		return this;
	}

	public DisputeEvidenceRequest customerCommunication(String customerCommunication) {
		this.customerCommunication = customerCommunication;
		return this;
	}

	public DisputeEvidenceRequest serviceDate(String serviceDate) {
		this.serviceDate = serviceDate;
		return this;
	}

	public DisputeEvidenceRequest serviceDocumentation(String serviceDocumentation) {
		this.serviceDocumentation = serviceDocumentation;
		return this;
	}

	public DisputeEvidenceRequest duplicateChargeId(String duplicateChargeId) {
		this.duplicateChargeId = duplicateChargeId;
		return this;
	}

	public DisputeEvidenceRequest duplicateChargeDocumentation(String duplicateChargeDocumentation) {
		this.duplicateChargeDocumentation = duplicateChargeDocumentation;
		return this;
	}

	public DisputeEvidenceRequest duplicateChargeExplanation(String duplicateChargeExplanation) {
		this.duplicateChargeExplanation = duplicateChargeExplanation;
		return this;
	}

	public DisputeEvidenceRequest refundPolicy(String refundPolicy) {
		this.refundPolicy = refundPolicy;
		return this;
	}

	public DisputeEvidenceRequest refundPolicyDisclosure(String refundPolicyDisclosure) {
		this.refundPolicyDisclosure = refundPolicyDisclosure;
		return this;
	}

	public DisputeEvidenceRequest refundRefusalExplanation(String refundRefusalExplanation) {
		this.refundRefusalExplanation = refundRefusalExplanation;
		return this;
	}

	public DisputeEvidenceRequest cancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
		return this;
	}

	public DisputeEvidenceRequest cancellationPolicyDisclosure(String cancellationPolicyDisclosure) {
		this.cancellationPolicyDisclosure = cancellationPolicyDisclosure;
		return this;
	}

	public DisputeEvidenceRequest cancellationRefusalExplanation(String cancellationRefusalExplanation) {
		this.cancellationRefusalExplanation = cancellationRefusalExplanation;
		return this;
	}

	public DisputeEvidenceRequest accessActivityLogs(String accessActivityLogs) {
		this.accessActivityLogs = accessActivityLogs;
		return this;
	}

	public DisputeEvidenceRequest shippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}

	public DisputeEvidenceRequest shippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
		return this;
	}

	public DisputeEvidenceRequest shippingCarrier(String shippingCarrier) {
		this.shippingCarrier = shippingCarrier;
		return this;
	}

	public DisputeEvidenceRequest shippingTrackingNumber(String shippingTrackingNumber) {
		this.shippingTrackingNumber = shippingTrackingNumber;
		return this;
	}

	public DisputeEvidenceRequest shippingDocumentation(String shippingDocumentation) {
		this.shippingDocumentation = shippingDocumentation;
		return this;
	}

	public DisputeEvidenceRequest uncategorizedText(String uncategorizedText) {
		this.uncategorizedText = uncategorizedText;
		return this;
	}

	public DisputeEvidenceRequest uncategorizedFile(String uncategorizedFile) {
		this.uncategorizedFile = uncategorizedFile;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public DisputeEvidenceRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
