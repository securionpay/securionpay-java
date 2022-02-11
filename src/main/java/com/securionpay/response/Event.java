package com.securionpay.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.securionpay.enums.EventType;
import com.securionpay.util.EventDataDeserializer;

import java.util.HashMap;
import java.util.Map;

import static com.securionpay.util.SecurionPayUtils.toStringNullSafe;

public class Event {

	private String id;
	private Long created;

	private String type;
	@JsonDeserialize(using = EventDataDeserializer.class)
	private Object data;
	private String log;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public EventType getType() {
		return EventType.fromValue(type);
	}

	public String getTypeAsString() {
		return type;
	}

	public Object getData() {
		return data;
	}

	public String getLog() {
		return log;
	}

	public String get(String name) {
		return toStringNullSafe(other.get(name));
	}

	@JsonAnySetter
	private void set(String name, Object value) {
		other.put(name, value);
	}
}
