package com.securionpay.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.securionpay.exception.MappingException;
import com.securionpay.response.ListResponse;

public class ObjectSerializer {

	public static final ObjectSerializer INSTANCE = new ObjectSerializer();

	private final ObjectMapper objectMapper;

	public ObjectSerializer() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
				.withFieldVisibility(Visibility.ANY)
				.withGetterVisibility(Visibility.NONE)
				.withSetterVisibility(Visibility.NONE)
				.withIsGetterVisibility(Visibility.NONE)
				.withCreatorVisibility(Visibility.NONE));
	}

	public String serialize(Object request) {
		try {
			return objectMapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			throw new MappingException(e);
		}
	}

	public <T> T deserialize(String responseBody, Class<T> responseClass) {
		return deserialize(responseBody, objectMapper.getTypeFactory().constructType(responseClass));
	}

	public <T> ListResponse<T> deserializeList(String responseBody, Class<T> elementClass) {
		return deserialize(responseBody,
				objectMapper.getTypeFactory().constructParametricType(ListResponse.class, elementClass));
	}

	private <T> T deserialize(String responseBody, JavaType responseType) {
		try {
			return objectMapper.readValue(responseBody, responseType);
		} catch (IOException e) {
			throw new MappingException(e);
		}
	}

	public String serializeToQueryString(Object request) {
		ObjectNode node = objectMapper.valueToTree(request);

		if (node instanceof ObjectNode == false) {
			return "";
		}

		URIBuilder url = new URIBuilder();
		buildQueryString(url, null, (ObjectNode) node);
		return url.toString();
	}

	private void buildQueryString(URIBuilder url, String path, ObjectNode node) {
		Iterator<Entry<String, JsonNode>> iterator = node.fields();
		while (iterator.hasNext()) {
			Entry<String, JsonNode> field = iterator.next();
			String fieldName = field.getKey();
			JsonNode childNode = field.getValue();

			if (childNode instanceof ObjectNode) {
				buildQueryString(url, getPath(path, fieldName), (ObjectNode) childNode);

			} else if (childNode instanceof ValueNode) {
				ValueNode valueNode = (ValueNode) childNode;

				if (!valueNode.isNull()) {
					url.addParameter(getPath(path, fieldName), valueNode.asText());
				}
			}
		}
	}

	private String getPath(String path, String fieldName) {
		if (path == null) {
			return fieldName;
		} else {
			return path + "[" + fieldName + "]";
		}
	}
}
