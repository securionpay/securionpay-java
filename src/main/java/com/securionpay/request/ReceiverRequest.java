package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

public class ReceiverRequest {
    private String firstName;
    private String lastName;
    private AddressRequest address;

    @JsonIgnore
    private final Map<String, Object> other = new HashMap<>();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public ReceiverRequest firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ReceiverRequest lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ReceiverRequest address(AddressRequest address) {
        this.address = address;
        return this;
    }
    
    @JsonAnyGetter
    private Map<String, Object> getOtherMap() {
        return other;
    }

    @JsonAnySetter
    private void set(String name, Object value) {
        other.put(name, value);
    }
}