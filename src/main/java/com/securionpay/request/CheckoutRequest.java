package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.response.Customer;
import com.securionpay.response.Plan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class CheckoutRequest {

	private Charge charge;
	private Subscription subscription;
	private CustomCharge customCharge;

	private String customerId;
	private List<String> crossSaleOfferIds;
	private Boolean rememberMe;
	private ThreeDSecureRequest threeDSecure;

	private String termsAndConditionsUrl;
	
	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public CheckoutRequest() {
	}

	public CheckoutRequest(Integer amount, String currency) {
		charge(amount, currency);
	}

	public CheckoutRequest(String planId) {
		subscription(planId);
	}

	public Charge getCharge() {
		return charge;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public CustomCharge getCustomCharge() {
		return customCharge;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<String> getCrossSaleOfferIds() {
		return crossSaleOfferIds;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public ThreeDSecureRequest getThreeDSecure() {
		return threeDSecure;
	}

	public String getTermsAndConditionsUrl() {
		return termsAndConditionsUrl;
	}

	public CheckoutRequest charge(Charge charge) {
		this.charge = charge;
		return this;
	}

	public CheckoutRequest charge(Integer amount, String currency) {
		return charge(new Charge(amount, currency));
	}

	public CheckoutRequest subscription(Subscription subscription) {
		this.subscription = subscription;
		return this;
	}

	public CheckoutRequest subscription(String planId) {
		return subscription(new Subscription(planId));
	}

	public CheckoutRequest customCharge(CustomCharge customCharge) {
		this.customCharge = customCharge;
		return this;
	}

	public CheckoutRequest customerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public CheckoutRequest customer(Customer customer) {
		return customerId(customer.getId());
	}

	public CheckoutRequest crossSaleOfferIds(String... crossSaleOfferIds) {
		return crossSaleOfferIds(Arrays.asList(crossSaleOfferIds));
	}

	public CheckoutRequest crossSaleOfferIds(List<String> crossSaleOfferIds) {
		this.crossSaleOfferIds = crossSaleOfferIds;
		return this;
	}

	public CheckoutRequest rememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
		return this;
	}

	public CheckoutRequest threeDSecure(ThreeDSecureRequest threeDSecure) {
		this.threeDSecure = threeDSecure;
		return this;
	}

	public CheckoutRequest termsAndConditionsUrl(String termsAndConditionsUrl) {
		this.termsAndConditionsUrl = termsAndConditionsUrl;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CheckoutRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}

	@JsonInclude(NON_NULL)
	public static class Charge {

		private Integer amount;
		private String currency;
		private Boolean capture;
		private Map<String, String> metadata;

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		public Charge() {
		}

		public Charge(Integer amount, String currency) {
			this.amount = amount;
			this.currency = currency;
		}

		public Integer getAmount() {
			return amount;
		}

		public String getCurrency() {
			return currency;
		}

		public Boolean getCapture() {
			return capture;
		}

		public Map<String, String> getMetadata() {
			return metadata;
		}

		public Charge amount(Integer amount) {
			this.amount = amount;
			return this;
		}

		public Charge currency(String currency) {
			this.currency = currency;
			return this;
		}

		public Charge capture(Boolean capture) {
			this.capture = capture;
			return this;
		}

		public Charge metadata(Map<String, String> metadata) {
			this.metadata = metadata;
			return this;
		}

		@JsonAnyGetter
		private Map<String, Object> getOtherMap() {
			return other;
		}

		@JsonAnySetter
		public Charge set(String name, Object value) {
			other.put(name, value);
			return this;
		}
	}

	@JsonInclude(NON_NULL)
	public static class Subscription {

		private String planId;
		private Boolean captureCharges;
		private Map<String, String> metadata;

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		public Subscription() {
		}

		public Subscription(String planId) {
			this.planId = planId;
		}

		public String getPlanId() {
			return planId;
		}

		public Boolean getCaptureCharges() {
			return captureCharges;
		}

		public Map<String, String> getMetadata() {
			return metadata;
		}

		public Subscription planId(String planId) {
			this.planId = planId;
			return this;
		}

		public Subscription plan(Plan plan) {
			return planId(plan.getId());
		}

		public Subscription captureCharges(Boolean captureCharges) {
			this.captureCharges = captureCharges;
			return this;
		}

		public Subscription metadata(Map<String, String> metadata) {
			this.metadata = metadata;
			return this;
		}

		@JsonAnyGetter
		private Map<String, Object> getOtherMap() {
			return other;
		}

		@JsonAnySetter
		public Subscription set(String name, Object value) {
			other.put(name, value);
			return this;
		}
	}

	@JsonInclude(NON_NULL)
	public static class CustomCharge {

		private List<Integer> amountOptions;
		private CustomAmount customAmount;

		private String currency;
		private Boolean capture;
		private Map<String, String> metadata;

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		public CustomCharge() {
		}

		public List<Integer> getAmountOptions() {
			return amountOptions;
		}

		public CustomAmount getCustomAmount() {
			return customAmount;
		}

		public String getCurrency() {
			return currency;
		}

		public Boolean getCapture() {
			return capture;
		}

		public Map<String, String> getMetadata() {
			return metadata;
		}

		public CustomCharge amountOptions(List<Integer> amountOptions) {
			this.amountOptions = amountOptions;
			return this;
		}

		public CustomCharge amountOptions(Integer... amountOptions) {
			return amountOptions(Arrays.asList(amountOptions));
		}

		public CustomCharge customAmount(CustomAmount customAmount) {
			this.customAmount = customAmount;
			return this;
		}

		public CustomCharge customAmount(Integer min, Integer max) {
			return customAmount(new CustomAmount(min, max));
		}

		public CustomCharge currency(String currency) {
			this.currency = currency;
			return this;
		}

		public CustomCharge capture(Boolean capture) {
			this.capture = capture;
			return this;
		}

		public CustomCharge metadata(Map<String, String> metadata) {
			this.metadata = metadata;
			return this;
		}

		@JsonAnyGetter
		private Map<String, Object> getOtherMap() {
			return other;
		}

		@JsonAnySetter
		public CustomCharge set(String name, Object value) {
			other.put(name, value);
			return this;
		}
	}

	@JsonInclude(NON_NULL)
	public static class CustomAmount {

		private Integer min;
		private Integer max;

		public CustomAmount() {
		}

		public CustomAmount(Integer min, Integer max) {
			this.min = min;
			this.max = max;
		}

		public Integer getMin() {
			return min;
		}

		public Integer getMax() {
			return max;
		}

		public CustomAmount min(Integer min) {
			this.min = min;
			return this;
		}

		public CustomAmount max(Integer max) {
			this.max = max;
			return this;
		}

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		@JsonAnyGetter
		private Map<String, Object> getOtherMap() {
			return other;
		}

		@JsonAnySetter
		public CustomAmount set(String name, Object value) {
			other.put(name, value);
			return this;
		}
	}

	@JsonInclude(NON_NULL)
	public static class ThreeDSecureRequest {
		private Boolean enable;
		private Boolean requireEnrolledCard;
		private Boolean requireSuccessfulLiabilityShiftForEnrolledCard;

		@JsonIgnore
		private final Map<String, Object> other = new HashMap<>();

		public Boolean getEnable() {
			return enable;
		}

		public Boolean getRequireEnrolledCard() {
			return requireEnrolledCard;
		}

		public Boolean getRequireSuccessfulLiabilityShiftForEnrolledCard() {
			return requireSuccessfulLiabilityShiftForEnrolledCard;
		}

		public ThreeDSecureRequest enable(Boolean enable) {
			this.enable = enable;
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
}
