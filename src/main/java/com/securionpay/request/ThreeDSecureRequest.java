package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ThreeDSecureRequest {

	private Boolean requireAttempt;
	private Boolean requireEnrolledCard;
	private Boolean requireSuccessfulLiabilityShiftForEnrolledCard;

	private External external;

	@JsonIgnore
	private final Map<String, Object> other = new HashMap<>();

	public Boolean getRequireAttempt() {
		return requireAttempt;
	}

	public Boolean getRequireEnrolledCard() {
		return requireEnrolledCard;
	}

	public Boolean getRequireSuccessfulLiabilityShiftForEnrolledCard() {
		return requireSuccessfulLiabilityShiftForEnrolledCard;
	}

	public External getExternal() {
		return external;
	}

	public ThreeDSecureRequest requireAttempt(Boolean requireAttempt) {
		this.requireAttempt = requireAttempt;
		return this;
	}

	public ThreeDSecureRequest requireEnrolledCard(Boolean requireEnrolledCard) {
		this.requireEnrolledCard = requireEnrolledCard;
		return this;
	}

	public ThreeDSecureRequest requireSuccessfulLiabilityShiftForEnrolledCard(Boolean requireSuccessfulLiabilityShiftForEnrolledCard) {
		this.requireSuccessfulLiabilityShiftForEnrolledCard = requireSuccessfulLiabilityShiftForEnrolledCard;
		return this;
	}

	public ThreeDSecureRequest external(External external) {
		this.external = external;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return other;
	}

	@JsonAnySetter
	public ThreeDSecureRequest set(String name, Object value) {
		other.put(name, value);
		return this;
	}

	public static class External {
		private String version;
		private String xid;
		private String eci;
		private String authenticationValue;
		private String dsTransactionId;
		private String acsTransactionId;
		private Status status;

		public String getVersion() {
			return version;
		}

		public String getXid() {
			return xid;
		}

		public String getEci() {
			return eci;
		}

		public String getAuthenticationValue() {
			return authenticationValue;
		}

		public String getDsTransactionId() {
			return dsTransactionId;
		}

		public String getAcsTransactionId() {
			return acsTransactionId;
		}

		public Status getStatus() {
			return status;
		}

		public External version(String version) {
			this.version = version;
			return this;
		}

		public External xid(String xid) {
			this.xid = xid;
			return this;
		}

		public External eci(String eci) {
			this.eci = eci;
			return this;
		}

		public External authenticationValue(String authenticationValue) {
			this.authenticationValue = authenticationValue;
			return this;
		}

		public External dsTransactionId(String dsTransactionId) {
			this.dsTransactionId = dsTransactionId;
			return this;
		}

		public External acsTransactionId(String acsTransactionId) {
			this.acsTransactionId = acsTransactionId;
			return this;
		}

		public External status(Status status) {
			this.status = status;
			return this;
		}

		enum Status {
			Y, N, A, U, R, E
		}
	}
}