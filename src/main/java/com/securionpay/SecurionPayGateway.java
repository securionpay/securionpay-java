package com.securionpay;

import static java.lang.String.format;

import java.io.Closeable;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.securionpay.connection.Connection;
import com.securionpay.connection.HttpClientConnection;
import com.securionpay.connection.Response;
import com.securionpay.exception.SecurionPayException;
import com.securionpay.request.BlacklistRuleListRequest;
import com.securionpay.request.BlacklistRuleRequest;
import com.securionpay.request.CaptureRequest;
import com.securionpay.request.CardListRequest;
import com.securionpay.request.CardRequest;
import com.securionpay.request.CardUpdateRequest;
import com.securionpay.request.ChargeListRequest;
import com.securionpay.request.ChargeRequest;
import com.securionpay.request.ChargeUpdateRequest;
import com.securionpay.request.CustomerListRequest;
import com.securionpay.request.CustomerRequest;
import com.securionpay.request.CustomerUpdateRequest;
import com.securionpay.request.EventListRequest;
import com.securionpay.request.SubscriptionCancelRequest;
import com.securionpay.request.SubscriptionListRequest;
import com.securionpay.request.PlanListRequest;
import com.securionpay.request.PlanRequest;
import com.securionpay.request.PlanUpdateRequest;
import com.securionpay.request.RefundRequest;
import com.securionpay.request.SubscriptionRequest;
import com.securionpay.request.SubscriptionUpdateRequest;
import com.securionpay.request.TokenRequest;
import com.securionpay.response.BlacklistRule;
import com.securionpay.response.Card;
import com.securionpay.response.Charge;
import com.securionpay.response.Customer;
import com.securionpay.response.DeleteResponse;
import com.securionpay.response.ErrorResponse;
import com.securionpay.response.Event;
import com.securionpay.response.ListResponse;
import com.securionpay.response.Plan;
import com.securionpay.response.Subscription;
import com.securionpay.response.Token;
import com.securionpay.util.ObjectSerializer;
import com.securionpay.util.SecurionPayUtils;

public class SecurionPayGateway implements Closeable {

	public static final String DEFAULT_ENDPOINT = "https://api.securionpay.com/";

	private static final String CHARGES_PATH = "/charges";
	private static final String TOKENS_PATH = "/tokens";
	private static final String CUSTOMERS_PATH = "/customers";
	private static final String CARDS_PATH = "/customers/%s/cards";
	private static final String PLANS_PATH = "/plans";
	private static final String SUBSCRIPTIONS_PATH = "/customers/%s/subscriptions";
	private static final String EVENTS_PATH = "/events";
	private static final String BLACKLIST_RULE_PATH = "/blacklist";

	private final ObjectSerializer objectSerializer = ObjectSerializer.INSTANCE;

	private Connection connection;

	private String privateKey;
	private String endpoint = DEFAULT_ENDPOINT;

	public SecurionPayGateway() {
		this(null);
	}

	public SecurionPayGateway(String privateKey) {
		this(privateKey, new HttpClientConnection());
	}

	public SecurionPayGateway(String privateKey, Connection connection) {
		this.privateKey = privateKey;
		this.connection = connection;
	}

	public Charge createCharge(ChargeRequest request) {
		return post(CHARGES_PATH, request, Charge.class);
	}

	public Charge captureCharge(CaptureRequest request) {
		return post(CHARGES_PATH + "/" + request.getChargeId() + "/capture", request, Charge.class);
	}

	public Charge retrieveCharge(String chargeId) {
		return get(CHARGES_PATH + "/" + chargeId, Charge.class);
	}

	public Charge updateCharge(ChargeUpdateRequest request) {
		return post(CHARGES_PATH + "/" + request.getChargeId(), request, Charge.class);
	}

	public Charge refundCharge(RefundRequest request) {
		return post(CHARGES_PATH + "/" + request.getChargeId() + "/refund", request, Charge.class);
	}

	public ListResponse<Charge> listCharges() {
		return list(CHARGES_PATH, Charge.class);
	}

	public ListResponse<Charge> listCharges(ChargeListRequest request) {
		return list(CHARGES_PATH, request, Charge.class);
	}

	public Customer createCustomer(CustomerRequest request) {
		return post(CUSTOMERS_PATH, request, Customer.class);
	}

	public Customer retrieveCustomer(String customerId) {
		return get(CUSTOMERS_PATH + "/" + customerId, Customer.class);
	}

	public Customer updateCustomer(CustomerUpdateRequest request) {
		return post(CUSTOMERS_PATH + "/" + request.getCustomerId(), request, Customer.class);
	}

	public DeleteResponse deleteCustomer(String customerId) {
		return delete(CUSTOMERS_PATH + "/" + customerId, DeleteResponse.class);
	}

	public ListResponse<Customer> listCustomers() {
		return list(CUSTOMERS_PATH, Customer.class);
	}

	public ListResponse<Customer> listCustomers(CustomerListRequest request) {
		return list(CUSTOMERS_PATH, request, Customer.class);
	}

	public Card createCard(CardRequest request) {
		return post(format(CARDS_PATH, request.getCustomerId()), request, Card.class);
	}

	public Card retrieveCard(String customerId, String cardId) {
		return get(format(CARDS_PATH, customerId) + "/" + cardId, Card.class);
	}

	public Card updateCard(CardUpdateRequest card) {
		return post(format(CARDS_PATH, card.getCustomerId()) + "/" + card.getCardId(), card, Card.class);
	}

	public DeleteResponse deleteCard(String customerId, String cardId) {
		return delete(format(CARDS_PATH, customerId) + "/" + cardId, DeleteResponse.class);
	}

	public ListResponse<Card> listCards(String customerId) {
		return listCards(new CardListRequest().customerId(customerId));
	}

	public ListResponse<Card> listCards(CardListRequest listCards) {
		return list(format(CARDS_PATH, listCards.getCustomerId()), listCards, Card.class);
	}

	public Subscription createSubscription(SubscriptionRequest request) {
		return post(format(SUBSCRIPTIONS_PATH, request.getCustomerId()), request, Subscription.class);
	}

	public Subscription retrieveSubscription(String customerId, String subscriptionId) {
		return get(format(SUBSCRIPTIONS_PATH, customerId) + "/" + subscriptionId, Subscription.class);
	}

	public Subscription updateSubscription(SubscriptionUpdateRequest request) {
		return post(format(SUBSCRIPTIONS_PATH, request.getCustomerId()) + "/" + request.getSubscriptionId(), request,
				Subscription.class);
	}

	public Subscription cancelSubscription(SubscriptionCancelRequest request) {
		return delete(format(SUBSCRIPTIONS_PATH, request.getCustomerId()) + "/" + request.getSubscriptionId(), request,
				Subscription.class);
	}

	public ListResponse<Subscription> listSubscriptions(String customerId) {
		return list(format(SUBSCRIPTIONS_PATH, customerId), Subscription.class);
	}

	public ListResponse<Subscription> listSubscriptions(SubscriptionListRequest request) {
		return list(format(SUBSCRIPTIONS_PATH, request.getCustomerId()), request, Subscription.class);
	}

	public Plan createPlan(PlanRequest request) {
		return post(PLANS_PATH, request, Plan.class);
	}

	public Plan retrievePlan(String planId) {
		return get(PLANS_PATH + "/" + planId, Plan.class);
	}

	public Plan updatePlan(PlanUpdateRequest request) {
		return post(PLANS_PATH + "/" + request.getPlanId(), request, Plan.class);
	}

	public DeleteResponse deletePlan(String planId) {
		return delete(PLANS_PATH + "/" + planId, DeleteResponse.class);
	}

	public ListResponse<Plan> listPlans() {
		return list(PLANS_PATH, Plan.class);
	}

	public ListResponse<Plan> listPlans(PlanListRequest request) {
		return list(PLANS_PATH, request, Plan.class);
	}

	public Event retrieveEvent(String eventId) {
		return get(format(EVENTS_PATH + "/" + eventId), Event.class);
	}

	public ListResponse<Event> listEvents() {
		return list(EVENTS_PATH, Event.class);
	}

	public ListResponse<Event> listEvents(EventListRequest listEvents) {
		return list(EVENTS_PATH, listEvents, Event.class);
	}

	public Token createToken(TokenRequest request) {
		return post(TOKENS_PATH, request, Token.class);
	}

	public Token retrieveToken(String tokenId) {
		return get(TOKENS_PATH + "/" + tokenId, Token.class);
	}

	public BlacklistRule createBlacklistRule(BlacklistRuleRequest request) {
		return post(BLACKLIST_RULE_PATH, request, BlacklistRule.class);
	}

	public BlacklistRule retrieveBlacklistRule(String blacklistRuleId) {
		return get(BLACKLIST_RULE_PATH + "/" + blacklistRuleId, BlacklistRule.class);
	}

	public DeleteResponse deleteBlacklistRule(String blacklistRuleId) {
		return delete(BLACKLIST_RULE_PATH + "/" + blacklistRuleId, DeleteResponse.class);
	}

	public ListResponse<BlacklistRule> listBlacklistRules() {
		return list(BLACKLIST_RULE_PATH, BlacklistRule.class);
	}

	public ListResponse<BlacklistRule> listBlacklistRules(BlacklistRuleListRequest request) {
		return list(BLACKLIST_RULE_PATH, request, BlacklistRule.class);
	}

	@Override
	public void close() throws IOException {
		if (connection != null) {
			connection.close();
		}
	}

	private <T> T get(String path, Class<T> responseClass) {
		Response response = connection.get(endpoint + path, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	private <T> T post(String path, Object request, Class<T> responseClass) {
		String requestBody = objectSerializer.serialize(request);
		Response response = connection.post(endpoint + path, requestBody, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	private <T> ListResponse<T> list(String path, Class<T> elementClass) {
		return list(path, null, elementClass);
	}

	private <T> ListResponse<T> list(String path, Object request, Class<T> elementClass) {
		String url = buildQueryString(endpoint + path, request);
		Response response = connection.get(url, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserializeList(response.getBody(), elementClass);
	}

	private <T> T delete(String path, Class<T> responseClass) {
		return delete(path, null, responseClass);
	}

	private <T> T delete(String path, Object request, Class<T> responseClass) {
		String url = buildQueryString(endpoint + path, request);
		Response response = connection.delete(url, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	private Response ensureSuccess(Response response) {
		if (response.getStatus() != 200) {
			ErrorResponse error = objectSerializer.deserialize(response.getBody(), ErrorResponse.class);
			throw new SecurionPayException(error);
		}
		return response;
	}

	private String buildQueryString(String url, Object request) {
		if (request == null) {
			return url;
		}

		return url + objectSerializer.serializeToQueryString(request);
	}

	private Map<String, String> buildHeaders() {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put("Authorization", "Basic " + Base64.getEncoder().encodeToString((privateKey + ":").getBytes()));
		headers.put("Content-Type", "application/json");
		headers.put("User-Agent", "SecurionPay-Java/" + SecurionPayUtils.getBuildVersion()
				+ " (Java/" + SecurionPayUtils.getJavaVersion() + ")");

		return headers;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
