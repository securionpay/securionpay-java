package com.securionpay.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.securionpay.response.Expandable;

import java.io.IOException;

public class ExpandableDeserializer extends JsonDeserializer<Expandable<?>> implements ContextualDeserializer {

    private JavaType objectType;

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) {
        ExpandableDeserializer deserializer = new ExpandableDeserializer();

        if (context != null && context.getContextualType() != null) {
            deserializer.objectType = context.getContextualType().containedType(0);
        } else if (property != null && property.getType() != null) {
            deserializer.objectType = property.getType().containedType(0);
        }

        return deserializer;
    }

    @Override
    public Expandable<?> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode node = mapper.readTree(parser);

        if (node.isTextual()) {
            return new Expandable<>(node.textValue());

        } else {
            String id = getId(node);
            Object object = mapper.readValue(mapper.treeAsTokens(node), objectType);

            return new Expandable<>(id, object);
        }
    }

    private String getId(JsonNode node) {
        JsonNode idNode = node.get("id");

        if (idNode == null || !idNode.isTextual()) {
            return null;
        }

        return idNode.textValue();
    }
}
