package com.securionpay.response;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.securionpay.enums.CrossSaleOfferTemplate;

public class CrossSaleOffer {

	private String id;
	private Long created;
	private boolean deleted = false;

	private Charge charge;
	private Subscription subscription;

	private CrossSaleOfferTemplate template;
	private String title;
	private String description;
	private String imageUrl;

	private String companyName;
	private String companyLocation;
	private String termsAndConditionsUrl;

	private String partnerId;

	private Boolean visibleForAllPartners;
	private List<String> visibleForPartnerIds;

	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public boolean isDeleted() {
		return deleted;
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

	public String getImageUrl() {
		return imageUrl;
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

	public String getPartnerId() {
		return partnerId;
	}

	public Boolean getVisibleForAllPartners() {
		return visibleForAllPartners;
	}

	public List<String> getVisibleForPartnerIds() {
		return visibleForPartnerIds;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}

	public static class Charge {

		private Integer amount;
		private String currency;
		private Boolean capture;

		@JsonIgnore
		private Map<String, Object> other = new HashMap<String, Object>();

		public Integer getAmount() {
			return amount;
		}

		public String getCurrency() {
			return currency;
		}

		public Boolean getCapture() {
			return capture;
		}

		public String get(String name) {
			return toStringNullSafe(other.get(name));
		}

		@JsonAnySetter
		private void set(String name, Object value) {
			other.put(name, value);
		}
	}

	public static class Subscription {

		private String planId;
		private Boolean captureCharges;

		@JsonIgnore
		private Map<String, Object> other = new HashMap<String, Object>();

		public String getPlanId() {
			return planId;
		}

		public Boolean getCaptureCharges() {
			return captureCharges;
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
