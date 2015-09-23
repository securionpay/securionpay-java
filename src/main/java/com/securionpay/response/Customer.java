package com.securionpay.response;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer {

	private String id;
	private Long created;
	private boolean deleted = false;

	private String email;
	private String description;
	private String defaultCardId;
	private List<Card> cards;
	private CustomerRecord customerRecord;
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

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public String getDefaultCardId() {
		return defaultCardId;
	}

	public Card getDefaultCard() {
		for (Card card : getCards()) {
			if (card.getId().equals(getDefaultCardId())) {
				return card;
			}
		}

		return null;
	}

	public List<Card> getCards() {
		return cards;
	}

	public CustomerRecord getCustomerRecord() {
		return customerRecord;
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

	public static class CustomerRecord {
		private String id;
		private boolean found;

		public String getId() {
			return id;
		}

		public boolean isFound() {
			return found;
		}
	}
}
