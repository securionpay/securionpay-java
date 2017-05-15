package com.securionpay.request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.enums.CrossSaleOfferTemplate;
import com.securionpay.response.Plan;

@JsonInclude(Include.NON_NULL)
public class CrossSaleOfferRequest {

	private Charge charge;
	private Subscription subscription;

	private CrossSaleOfferTemplate template;
	private String title;
	private String description;
	private String imageData;

	private String companyName;
	private String companyLocation;
	private String termsAndConditionsUrl;

	private Boolean visibleForAllPartners;
	private List<String> visibleForPartnerIds;

	private String url;

	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CrossSaleOfferRequest() {
	}

	public Charge getCharge() {
		return charge;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public CrossSaleOfferTemplate getTemplate() {
		return template;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getImageData() {
		return imageData;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public String getTermsAndConditionsUrl() {
		return termsAndConditionsUrl;
	}

	public Boolean getVisibleForAllPartners() {
		return visibleForAllPartners;
	}

	public List<String> getVisibleForPartnerIds() {
		return visibleForPartnerIds;
	}

	public String getUrl() {
		return url;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public CrossSaleOfferRequest charge(Charge charge) {
		this.charge = charge;
		return this;
	}

	public CrossSaleOfferRequest charge(Integer amount, String currency) {
		return charge(new Charge(amount, currency));
	}

	public CrossSaleOfferRequest subscription(Subscription subscription) {
		this.subscription = subscription;
		return this;
	}

	public CrossSaleOfferRequest subscription(String planId) {
		return subscription(new Subscription(planId));
	}

	public CrossSaleOfferRequest template(CrossSaleOfferTemplate template) {
		this.template = template;
		return this;
	}

	public CrossSaleOfferRequest title(String title) {
		this.title = title;
		return this;
	}

	public CrossSaleOfferRequest description(String description) {
		this.description = description;
		return this;
	}

	public CrossSaleOfferRequest imageData(String imageData) {
		this.imageData = imageData;
		return this;
	}

	public CrossSaleOfferRequest companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public CrossSaleOfferRequest companyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
		return this;
	}

	public CrossSaleOfferRequest termsAndConditionsUrl(String termsAndConditionsUrl) {
		this.termsAndConditionsUrl = termsAndConditionsUrl;
		return this;
	}

	public CrossSaleOfferRequest visibleForAllPartners(Boolean visibleForAllPartners) {
		this.visibleForAllPartners = visibleForAllPartners;
		return this;
	}

	public CrossSaleOfferRequest visibleForPartnerIds(List<String> visibleForPartnerIds) {
		this.visibleForPartnerIds = visibleForPartnerIds;
		return this;
	}

	public CrossSaleOfferRequest visibleForPartnerIds(String... visibleForPartnerIds) {
		return visibleForPartnerIds(Arrays.asList(visibleForPartnerIds));
	}

	public CrossSaleOfferRequest url(String url) {
		this.url = url;
		return this;
	}

	public CrossSaleOfferRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CrossSaleOfferRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}

	@JsonInclude(Include.NON_NULL)
	public static class Charge {

		private Integer amount;
		private String currency;
		private Boolean capture;

		@JsonIgnore
		private Map<String, Object> other = new HashMap<String, Object>();

		public Charge() {
		}

		public Charge(Integer amount, String currency) {
			amount(amount).currency(currency);
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

	@JsonInclude(Include.NON_NULL)
	public static class Subscription {

		private String planId;
		private Boolean captureCharges;

		@JsonIgnore
		private Map<String, Object> other = new HashMap<String, Object>();

		public Subscription() {
		}

		public Subscription(String planId) {
			planId(planId);
		}

		public Subscription(Plan plan) {
			plan(plan);
		}

		public String getPlanId() {
			return planId;
		}

		public Boolean getCaptureCharges() {
			return captureCharges;
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
}
