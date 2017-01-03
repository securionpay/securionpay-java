package com.securionpay.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.securionpay.response.*;

public class EventDataDeserializer extends JsonDeserializer<Object> {

	static final String OBJECT_TYPE_KEY = "objectType";
	static Map<String, Class<?>> OBJECT_TYPES = new HashMap<>();

	static {
		OBJECT_TYPES.put("customer", Customer.class);
		OBJECT_TYPES.put("card", Card.class);
		OBJECT_TYPES.put("charge", Charge.class);
		OBJECT_TYPES.put("dispute", Dispute.class);
		OBJECT_TYPES.put("plan", Plan.class);
		OBJECT_TYPES.put("subscription", Subscription.class);
		OBJECT_TYPES.put("crossSaleOffer", CrossSaleOffer.class);
		OBJECT_TYPES.put("customerRecord", CustomerRecord.class);
		OBJECT_TYPES.put("customerRecordProfit", CustomerRecordProfit.class);
		OBJECT_TYPES.put("customerRecordFee", CustomerRecordFee.class);
	}

	private final ObjectSerializer objectSerializer = ObjectSerializer.INSTANCE;

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		if (!node.has(OBJECT_TYPE_KEY)) {
			return null;
		}

		String objectType = node.get(OBJECT_TYPE_KEY).asText();
		Class<?> objectClass = OBJECT_TYPES.get(objectType);
		if (objectClass == null) {
			return null;
		}

		return objectSerializer.deserialize(node.toString(), objectClass);
	}

}
