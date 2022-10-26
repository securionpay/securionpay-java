package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.ChargeStatus;
import com.securionpay.enums.ErrorCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Charge {

	private String id;
	private String clientObjectId;
	private Long created;
	private Integer amount;
	private Integer amountRefunded;
	private String currency;
	private String description;
	private ChargeStatus status;
	private Card card;
	private PaymentMethod paymentMethod;
	private ChargeFlow flow;
	private String customerId;
	private String subscriptionId;
	private Boolean captured;
	private Boolean refunded;
	private List<Refund> refunds;
	private Boolean disputed;
	private FraudDetails fraudDetails;
	private Shipping shipping;
	private Billing billing;
	private ThreeDSecureInfo threeDSecureInfo;

	private FromCrossSale fromCrossSale;
	private List<WithCrossSale> withCrossSales;

	private Dispute dispute;

	private String merchantAccountId;

	private Map<String, String> metadata;

	private String failureCode;
	private String failureIssuerDeclineCode;
	private String failureMessage;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public String getClientObjectId() {
		return clientObjectId;
	}

	public Long getCreated() {
		return created;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getAmountRefunded() {
		return amountRefunded;
	}

	public String getCurrency() {
		return currency;
	}

	public String getDescription() {
		return description;
	}

	public ChargeStatus getStatus() {
		return status;
	}

	public Card getCard() {
		return card;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public ChargeFlow getFlow() {
		return flow;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public Boolean getCaptured() {
		return captured;
	}

	public Boolean getRefunded() {
		return refunded;
	}

	public List<Refund> getRefunds() {
		return refunds;
	}

	public Boolean getDisputed() {
		return disputed;
	}

	public FraudDetails getFraudDetails() {
		return fraudDetails;
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

	public FromCrossSale getFromCrossSale() {
		return fromCrossSale;
	}

	public List<WithCrossSale> getWithCrossSales() {
		return withCrossSales;
	}

	public Dispute getDispute() {
		return dispute;
	}

	public String getMerchantAccountId() {
		return merchantAccountId;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public ErrorCode getFailureCode() {
		return ErrorCode.fromValue(failureCode);
	}

	public String getFailureCodeAsString() {
		return failureCode;
	}

	public String getFailureIssuerDeclineCode() {
		return failureIssuerDeclineCode;
	}

	public String getFailureMessage() {
		return failureMessage;
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

	public static class FromCrossSale {
		private String offerId;
		private String partnerId;

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		public String getOfferId() {
			return offerId;
		}

		public String getPartnerId() {
			return partnerId;
		}

		public String get(String name) {
			return toStringNullSafe(other.get(name));
		}

		@JsonAnySetter
		private void set(String name, Object value) {
			other.put(name, value);
		}
	}

	public static class WithCrossSale {
		private String offerId;
		private String partnerId;

		private String chargeId;
		private Integer amount;
		private String currency;
		private String subscriptionId;

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		public String getOfferId() {
			return offerId;
		}

		public String getPartnerId() {
			return partnerId;
		}

		public String getChargeId() {
			return chargeId;
		}

		public String getSubscriptionId() {
			return subscriptionId;
		}

		public Integer getAmount() {
			return amount;
		}

		public String getCurrency() {
			return currency;
		}

		public String get(String name) {
			return toStringNullSafe(other.get(name));
		}

		@JsonAnySetter
		private void set(String name, Object value) {
			other.put(name, value);
		}
	}
}
