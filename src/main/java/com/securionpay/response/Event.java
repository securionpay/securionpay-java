package com.securionpay.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.securionpay.enums.EventType;
import com.securionpay.util.EventDataDeserializer;

public class Event {

	private String id;
	private Long created;

	private String type;
	@JsonDeserialize(using = EventDataDeserializer.class)
	private Object data;
	private String log;

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
}
