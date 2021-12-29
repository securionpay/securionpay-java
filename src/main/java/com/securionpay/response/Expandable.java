package com.securionpay.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.securionpay.util.ExpandableDeserializer;

@JsonDeserialize(using = ExpandableDeserializer.class)
public class Expandable<T> {

    private String id;
    private T object;

    public Expandable(String id) {
        this.id = id;
    }

    public Expandable(String id, T object) {
        this.id = id;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public T get() {
        return object;
    }

    public boolean isExpanded() {
        return object != null;
    }
}
