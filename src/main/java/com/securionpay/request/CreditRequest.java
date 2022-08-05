package com.securionpay.request;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.securionpay.response.Customer;

@JsonInclude(NON_NULL)
public class CreditRequest {
    private Integer amount;
    private String currency;
    private String customerId;
    private CardRequest card;
    private String description;
    private ReceiverRequest receiver;
    private String merchantAccountId;

    private Map<String, String> metadata;

    @JsonIgnore
    private final Map<String, Object> other = new HashMap<>();

    public CreditRequest() {
    }

    public CreditRequest(Integer amount, String currency) {
        amount(amount).currency(currency);
    }

    public Integer getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public ReceiverRequest getReceiver() {
        return receiver;
    }

    public String getCustomerId() {
        return customerId;
    }

    public CardRequest getCard() {
        return card;
    }

    public String getMerchantAccountId() {
        return merchantAccountId;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public CreditRequest amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public CreditRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreditRequest description(String description) {
        this.description = description;
        return this;
    }

    public CreditRequest receiver(ReceiverRequest receiver) {
        this.receiver = receiver;
        return this;
    }

    public CreditRequest customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public CreditRequest customer(Customer customer) {
        return customerId(customer.getId());
    }

    public CreditRequest card(CardRequest card) {
        this.card = card;
        return this;
    }

    public CreditRequest merchantAccountId(String merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
        return this;
    }

    public CreditRequest metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonAnyGetter
    private Map<String, Object> getOtherMap() {
        return other;
    }

    @JsonAnySetter
    public CreditRequest set(String name, Object value) {
        other.put(name, value);
        return this;
    }
}
