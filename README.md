# SecurionPay JAVA Library

If you don't already have SecurionPay account you can create it [here](https://securionpay.com/signup). 

## Instalation 

### Maven

Best way to use this library is via [Maven](https://maven.apache.org).

To do this you will need to add this configuration to your `pom.xml`:

```xml
<dependency>
    <groupId>com.securionpay</groupId>
    <artifactId>securionpay-java</artifactId>
    <version>2.9.0</version>
</dependency>
```

### Manual installation

If you don't want to use Maven then you can download [the latest release](https://github.com/securionpay/securionpay-java/releases).

## Quick start example

```java
SecurionPayGateway gateway = new SecurionPayGateway("sk_test_[YOUR_SECRET_KEY]");

ChargeRequest request = new ChargeRequest()
		.amount(499)
		.currency("EUR")
		.card(new CardRequest()
				.number("4242424242424242")
				.expMonth("11")
				.expYear("2022"));

try {
    Charge charge = gateway.createCharge(request);

    // do something with charge object - see https://securionpay.com/docs/api#charge-object
    String chargeId = charge.getId();

} catch (SecurionPayException e) {
    // handle error response - see https://securionpay.com/docs/api#error-object
    ErrorType errorType = e.getType();
    ErrorCode errorCode = e.getCode();
    String errorMessage = e.getMessage();
}
```

## Documentation


For further information, please refer to our official documentation at https://securionpay.com/docs.
