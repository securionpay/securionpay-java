package com.securionpay;

import com.securionpay.connection.Connection;
import com.securionpay.connection.HttpClientConnection;
import com.securionpay.connection.Response;
import com.securionpay.enums.FileUploadPurpose;
import com.securionpay.exception.SecurionPayException;
import com.securionpay.exception.SignException;
import com.securionpay.request.*;
import com.securionpay.response.*;
import com.securionpay.util.Base64;
import com.securionpay.util.ObjectSerializer;
import com.securionpay.util.SecurionPayUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import static org.apache.commons.codec.binary.Hex.encodeHexString;

public class SecurionPayGateway implements Closeable {

	public static final String DEFAULT_ENDPOINT = "https://api.securionpay.com/";
	public static final String UPLOADS_ENDPOINT = "https://uploads.securionpay.com/";

	private static final String CHARGES_PATH = "/charges";
	private static final String TOKENS_PATH = "/tokens";
	private static final String CUSTOMERS_PATH = "/customers";
	private static final String CARDS_PATH = "/customers/%s/cards";
	private static final String PLANS_PATH = "/plans";
	private static final String SUBSCRIPTIONS_PATH = "/subscriptions";
	private static final String EVENTS_PATH = "/events";
	private static final String BLACKLIST_RULE_PATH = "/blacklist";
	private static final String CROSS_SALE_OFFER_PATH = "/cross-sale-offers";
	private static final String CREDIT_PATH = "/credits";
	private static final String FILES_PATH = "/files";
	private static final String DISPUTES_PATH = "/disputes";
	private static final String FRAUD_WARNING_PATH = "/fraud-warnings";

	private final ObjectSerializer objectSerializer = ObjectSerializer.INSTANCE;

	private Connection connection;

	private String secretKey;
	private String endpoint = DEFAULT_ENDPOINT;
	private String uploadsEndpoint = UPLOADS_ENDPOINT;

	public SecurionPayGateway() {
		this(null);
	}

	public SecurionPayGateway(String secretKey) {
		this(secretKey, new HttpClientConnection());
	}

	public SecurionPayGateway(String secretKey, Connection connection) {
		this.secretKey = secretKey;
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
		return post(SUBSCRIPTIONS_PATH, request, Subscription.class);
	}

	public Subscription retrieveSubscription(String subscriptionId) {
		return get(SUBSCRIPTIONS_PATH + "/" + subscriptionId, Subscription.class);
	}

	public Subscription updateSubscription(SubscriptionUpdateRequest request) {
		return post(SUBSCRIPTIONS_PATH + "/" + request.getSubscriptionId(), request, Subscription.class);
	}

	public Subscription cancelSubscription(SubscriptionCancelRequest request) {
		return delete(SUBSCRIPTIONS_PATH + "/" + request.getSubscriptionId(), request, Subscription.class);
	}

	public ListResponse<Subscription> listSubscriptions(String customerId) {
		return listSubscriptions(new SubscriptionListRequest().customerId(customerId));
	}

	public ListResponse<Subscription> listSubscriptions(SubscriptionListRequest request) {
		return list(SUBSCRIPTIONS_PATH, request, Subscription.class);
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
		return get(EVENTS_PATH + "/" + eventId, Event.class);
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

	public CrossSaleOffer createCrossSaleOffer(CrossSaleOfferRequest request) {
		return post(CROSS_SALE_OFFER_PATH, request, CrossSaleOffer.class);
	}

	public CrossSaleOffer retrieveCrossSaleOffer(String crossSaleOfferId) {
		return get(CROSS_SALE_OFFER_PATH + "/" + crossSaleOfferId, CrossSaleOffer.class);
	}

	public CrossSaleOffer updateCrossSaleOffer(CrossSaleOfferUpdateRequest request) {
		return post(CROSS_SALE_OFFER_PATH + "/" + request.getCrossSaleOfferId(), request, CrossSaleOffer.class);
	}

	public DeleteResponse deleteCrossSaleOffer(String crossSaleOfferId) {
		return delete(CROSS_SALE_OFFER_PATH + "/" + crossSaleOfferId, DeleteResponse.class);
	}

	public ListResponse<CrossSaleOffer> listCrossSaleOffers() {
		return list(CROSS_SALE_OFFER_PATH, CrossSaleOffer.class);
	}

	public ListResponse<CrossSaleOffer> listCrossSaleOffers(CrossSaleOfferListRequest request) {
		return list(CROSS_SALE_OFFER_PATH, request, CrossSaleOffer.class);
	}

	public Credit createCredit(CreditRequest request) {
		return post(CREDIT_PATH, request, Credit.class);
	}

	public Credit retrieveCredit(String creditId) {
		return get(CREDIT_PATH + "/" + creditId, Credit.class);
	}

	public Credit updateCredit(CreditUpdateRequest credit) {
		return post(CREDIT_PATH + "/" + credit.getCreditId(), credit, Credit.class);
	}

	public ListResponse<Credit> listCredits() {
		return list(CREDIT_PATH, Credit.class);
	}

	public ListResponse<Credit> listCredits(CreditListRequest request) {
		return list(CREDIT_PATH, request, Credit.class);
	}

	public String signCheckoutRequest(CheckoutRequest checkoutRequest) {
		String data = objectSerializer.serialize(checkoutRequest);

		try {
			String algorithm = "HmacSHA256";

			Mac hmac = Mac.getInstance(algorithm);
			hmac.init(new SecretKeySpec(secretKey.getBytes(UTF_8), algorithm));
			String signature = encodeHexString(hmac.doFinal(data.getBytes(UTF_8)));

			return encodeBase64String((signature + "|" + data).getBytes(UTF_8));
		} catch (Exception ex) {
			throw new SignException(ex);
		}
	}

	public FileUpload createFileUpload(File file, FileUploadPurpose purpose) {
		Map<String, File> files = new HashMap<>();
		files.put("file", file);

		Map<String, String> form = new HashMap<>();
		form.put("purpose", purpose.getValue());

		return multipart(FILES_PATH, files, form, FileUpload.class);
	}

	public FileUpload retrieveFileUpload(String id) {
		return get(uploadsEndpoint, FILES_PATH + "/" + id, FileUpload.class);
	}

	public ListResponse<FileUpload> listFileUploads() {
		return list(uploadsEndpoint, FILES_PATH, null, FileUpload.class);
	}

	public ListResponse<FileUpload> listFileUploads(FileUploadListRequest request) {
		return list(uploadsEndpoint, FILES_PATH, request, FileUpload.class);
	}

	public Dispute retrieveDispute(String id) {
		return get(DISPUTES_PATH + "/" + id, Dispute.class);
	}

	public Dispute updateDispute(DisputeUpdateRequest request) {
		return post(DISPUTES_PATH + "/" + request.getDisputeId(), request, Dispute.class);
	}

	public Dispute closeDispute(String id) {
		return post(DISPUTES_PATH + "/" + id + "/close", null, Dispute.class);
	}

	public ListResponse<Dispute> listDisputes() {
		return list(DISPUTES_PATH, null, Dispute.class);
	}

	public ListResponse<Dispute> listDisputes(DisputeListRequest request) {
		return list(DISPUTES_PATH, request, Dispute.class);
	}

	public ListResponse<FraudWarning> listFraudWarnings() {
		return list(FRAUD_WARNING_PATH, FraudWarning.class);
	}

	public ListResponse<FraudWarning> listFraudWarnings(FraudWarningListRequest request) {
		return list(FRAUD_WARNING_PATH, request, FraudWarning.class);
	}

	public FraudWarning retrieveFraudWarning(String id) {
		return get(FRAUD_WARNING_PATH + "/" + id, FraudWarning.class);
	}

	public Payout retrievePayout(String id) {
		return get("/payouts/" + id, Payout.class);
	}

	public ListResponse<Payout> listPayouts() {
		return list("/payouts", Payout.class);
	}

	public ListResponse<Payout> listPayouts(PayoutListRequest request) {
		return list("/payouts", request, Payout.class);
	}

	public ListResponse<PayoutTransaction> listPayoutTransactions(String payoutId) {
		PayoutTransactionListRequest request = new PayoutTransactionListRequest();
		request.setPayout(payoutId);
		return list("/payout-transactions", request, PayoutTransaction.class);
	}

	public ListResponse<PayoutTransaction> listPayoutTransactions(PayoutTransactionListRequest request) {
		return list("/payout-transactions", request, PayoutTransaction.class);
	}

	@Override
	public void close() throws IOException {
		if (connection != null) {
			connection.close();
		}
	}

	protected <T> T get(String path, Class<T> responseClass) {
		return get(endpoint, path, responseClass);
	}

	protected <T> T get(String path, Class<T> responseClass, Expand expand) {
		return get(endpoint, path, responseClass, expand);
	}

	protected <T> T get(String endpoint, String path, Class<T> responseClass) {
		return get(endpoint, path, responseClass, null);
	}

	protected <T> T get(String endpoint, String path, Class<T> responseClass, Expand expand) {
		RetrieveRequest request = new RetrieveRequest().expand(expand);
		String url = buildQueryString(endpoint + path, request);
		Response response = connection.get(url, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	protected <T> T post(String path, Object request, Class<T> responseClass) {
		String requestBody = objectSerializer.serialize(request);
		Response response = connection.post(endpoint + path, requestBody, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	protected <T> T multipart(String path, Map<String, File> files, Map<String, String> form, Class<T> responseClass) {
		Response response = connection.multipart(uploadsEndpoint + path, files, form, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	protected <T> ListResponse<T> list(String path, Class<T> elementClass) {
		return list(endpoint, path, null, elementClass);
	}

	protected <T> ListResponse<T> list(String path, Object request, Class<T> elementClass) {
		return list(endpoint, path, request, elementClass);
	}

	protected <T> ListResponse<T> list(String endpoint, String path, Object request, Class<T> elementClass) {
		String url = buildQueryString(endpoint + path, request);
		Response response = connection.get(url, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserializeList(response.getBody(), elementClass);
	}

	protected <T> T delete(String path, Class<T> responseClass) {
		return delete(path, null, responseClass);
	}

	protected <T> T delete(String path, Object request, Class<T> responseClass) {
		String url = buildQueryString(endpoint + path, request);
		Response response = connection.delete(url, buildHeaders());
		ensureSuccess(response);
		return objectSerializer.deserialize(response.getBody(), responseClass);
	}

	private void ensureSuccess(Response response) {
		if (response.getStatus() != 200) {
			ErrorResponse error = objectSerializer.deserialize(response.getBody(), ErrorResponse.class);
			throw new SecurionPayException(error);
		}
	}

	private String buildQueryString(String url, Object request) {
		if (request == null) {
			return url;
		}

		return url + objectSerializer.serializeToQueryString(request);
	}

	protected Map<String, String> buildHeaders() {
		Map<String, String> headers = new HashMap<>();

		headers.put("Authorization", "Basic " + Base64.encode((secretKey + ":").getBytes()));
		headers.put("Content-Type", "application/json");
		headers.put("User-Agent", "SecurionPay-Java/" + SecurionPayUtils.getBuildVersion()
				+ " (Java/" + SecurionPayUtils.getJavaVersion() + ")");

		return headers;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public void setUploadsEndpoint(String uploadsEndpoint) {
		this.uploadsEndpoint = uploadsEndpoint;
	}
}
