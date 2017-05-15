package com.securionpay.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.securionpay.enums.CrossSaleOfferTemplate;
import com.securionpay.request.CrossSaleOfferRequest.Charge;
import com.securionpay.request.CrossSaleOfferRequest.Subscription;
import com.securionpay.response.CrossSaleOffer;

@JsonInclude(Include.NON_NULL)
public class CrossSaleOfferUpdateRequest {

	@JsonIgnore
	private String crossSaleOfferId;

	private Charge charge;
	private Subscription subscription;

	private CrossSaleOfferTemplate template;
	private String title;
	private String description;
	private String imageData;

	private String companyName;
	private String companyLocation;
	private String termsAndConditionsUrl;

	private String url;

	private Boolean visibleForAllPartners;
	private List<String> visibleForPartnerIds;

	private Map<String, String> metadata;

	@JsonIgnore
	private Map<String, Object> other = new HashMap<String, Object>();

	public CrossSaleOfferUpdateRequest() {
	}

	public CrossSaleOfferUpdateRequest(String crossSaleOfferId) {
		crossSaleOfferId(crossSaleOfferId);
	}

	public CrossSaleOfferUpdateRequest(CrossSaleOffer crossSaleOffer) {
		crossSaleOffer(crossSaleOffer);
	}

	public String getCrossSaleOfferId() {
		return crossSaleOfferId;
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

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public CrossSaleOfferUpdateRequest crossSaleOfferId(String crossSaleOfferId) {
		this.crossSaleOfferId = crossSaleOfferId;
		return this;
	}

	public CrossSaleOfferUpdateRequest crossSaleOffer(CrossSaleOffer crossSaleOffer) {
		return crossSaleOfferId(crossSaleOffer.getId());
	}

	public CrossSaleOfferUpdateRequest charge(Charge charge) {
		this.charge = charge;
		return this;
	}

	public CrossSaleOfferUpdateRequest charge(Integer amount, String currency) {
		return charge(new Charge(amount, currency));
	}

	public CrossSaleOfferUpdateRequest subscription(Subscription subscription) {
		this.subscription = subscription;
		return this;
	}

	public CrossSaleOfferUpdateRequest subscription(String planId) {
		return subscription(new Subscription(planId));
	}

	public CrossSaleOfferUpdateRequest template(CrossSaleOfferTemplate template) {
		this.template = template;
		return this;
	}

	public CrossSaleOfferUpdateRequest title(String title) {
		this.title = title;
		return this;
	}

	public CrossSaleOfferUpdateRequest description(String description) {
		this.description = description;
		return this;
	}

	public CrossSaleOfferUpdateRequest imageData(String imageData) {
		this.imageData = imageData;
		return this;
	}

	public CrossSaleOfferUpdateRequest companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public CrossSaleOfferUpdateRequest companyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
		return this;
	}

	public CrossSaleOfferUpdateRequest termsAndConditionsUrl(String termsAndConditionsUrl) {
		this.termsAndConditionsUrl = termsAndConditionsUrl;
		return this;
	}

	public CrossSaleOfferUpdateRequest visibleForAllPartners(Boolean visibleForAllPartners) {
		this.visibleForAllPartners = visibleForAllPartners;
		return this;
	}

	public CrossSaleOfferUpdateRequest visibleForPartnerIds(List<String> visibleForPartnerIds) {
		this.visibleForPartnerIds = visibleForPartnerIds;
		return this;
	}

	public CrossSaleOfferUpdateRequest url(String url) {
		this.url = url;
		return this;
	}

	public CrossSaleOfferUpdateRequest metadata(Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public CrossSaleOfferUpdateRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}
}
